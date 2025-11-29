package com.icodi.microservices.customerservice.service;

import com.icodi.microservices.customerservice.dto.CustomerDTO;
import com.icodi.microservices.customerservice.entities.Customer;
import com.icodi.microservices.customerservice.exception.CustomerNotFoundException;
import com.icodi.microservices.customerservice.mapper.CustomerMapper;
import com.icodi.microservices.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    // Récupère tous les clients et les rend au front via le mapper et les DTO
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomers() {
        System.out.println("Récupération de tous les clients");
        List<Customer> customers = customerRepository.findAll();
        System.out.println(customers.size() + " clients trouvés");
        return customerMapper.customerListToCustomerDTOList(customers);
    }

    // Récupère un client via son ID
    @Transactional(readOnly = true)
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.customerToCustomerDTO(customer);
    }

    // Crée un nouveau client
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        System.out.println("Création d'un nouveau client :" + customerDTO.getCustomerEmail());

        //Vérification de l'email
        if(customerRepository.existsByCustomerEmail(customerDTO.getCustomerEmail())) {
            System.out.println("L'email " + customerDTO.getCustomerEmail() + " exitse déjà" );
            throw new IllegalArgumentException(
                    "Un client avec l'email " + customerDTO.getCustomerEmail() + " existe déjà."
            );
        }

        //Conversion du DTO en Entité
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);

        // Sauvegarde en base de données
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    // Mise à jour d'un client existant
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        System.out.println("Mise à jour du client :" + id);

        // Vérification si le client existe
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        // Vérification de l'email
        if(!existingCustomer.getCustomerEmail().equals(customerDTO.getCustomerEmail()) &&
                customerRepository.existsByCustomerEmail(customerDTO.getCustomerEmail())) {

            System.out.println("Tentative de modification avec un email déjà utilisé : " + customerDTO.getCustomerEmail());
            throw new IllegalArgumentException(
                    "Un autre client utilise déjà cet email : " + customerDTO.getCustomerEmail()
            );
        }

        // Mise à jour des champs non null du DTO
        customerMapper.updateCustomerFromCustomerDTO(customerDTO, existingCustomer);
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        System.out.println("Client " + id + " à jour avec succès");
        return customerMapper.customerToCustomerDTO(updatedCustomer);
    }

    // Suppression d'un client
    public void deleteCustomer(Long id) {
        System.out.println("Suppression du client : " + id);

        if(!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }

        customerRepository.deleteById(id);
        System.out.println("Client : " + id + " avec succès");
    }

    // Recherche des clients par nom ou prénom
    @Transactional(readOnly = true)
    public List<CustomerDTO> searchCustomers(String searchTerm) {
        System.out.println("Recherche des clients avec le terme : " + searchTerm);

        List<Customer> customers = customerRepository.searchByCustomerName(searchTerm);
        System.out.println(customers.size() + " clients trouvés");
        return customerMapper.customerListToCustomerDTOList(customers);
    }

    // Récupération d'un client par mail
    @Transactional(readOnly = true)
    public CustomerDTO getCustomerByEmail(String customerEmail) {
        System.out.println("Récupération du client avec l'email : " + customerEmail);

        Customer customer = customerRepository.findByCustomerEmail(customerEmail)
                .orElseThrow(()-> new CustomerNotFoundException(
                        "Client avec l'email " + customerEmail + "introuvable"));
        return customerMapper.customerToCustomerDTO(customer);
    }

    // Compte le nombre total de clients
    public long countCustomers() {
        System.out.println("Comptage du nombre total de clients :");
        long count = customerRepository.count();
        System.out.println("Nombre total de client : " + count);
        return count;
    }
}
