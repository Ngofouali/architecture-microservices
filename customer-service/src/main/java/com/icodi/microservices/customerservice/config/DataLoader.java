package com.icodi.microservices.customerservice.config;

import com.icodi.microservices.customerservice.entities.Customer;
import com.icodi.microservices.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("==================================");
        System.out.println(" Chargement des données de test...");
        System.out.println("==================================");

        if (customerRepository.count() > 0) {
            System.out.println(" Des clients existent déjà en base de données, fin de chargement");
            return;
        }

        // Création de clients avec Builder
        createCustomers();

        System.out.println("==================================");
        System.out.println(customerRepository.count() + " clients créés avec succès !");
        System.out.println("==================================");

    }

    // Création et sauvegarde des clients pour le test
    private void createCustomers() {

        Customer customer1 = Customer.builder()
                .customerName("Fofana N'gofouali")
                .customerEmail("fof.ngofouali@gmail.com")
                .customerPhone("0506499508")
                .build();
        customerRepository.save(customer1);
        System.out.println(" Client crée : " + customer1.getCustomerName());

        Customer customer2 = Customer.builder()
                .customerName("Marie Kouassi")
                .customerEmail("marie.kouassi@gmail.com")
                .customerPhone("0506123456")
                .build();
        customerRepository.save(customer2);
        System.out.println(" Client crée : " + customer2.getCustomerName());

        Customer customer3 = Customer.builder()
                .customerName("Pierre Akpro")
                .customerEmail("akpro.pierre@gmail.com")
                .customerPhone("0704789012")
                .build();
        customerRepository.save(customer3);
        System.out.println(" Client crée : " + customer3.getCustomerName());

        Customer customer4 = Customer.builder()
                .customerName("Touré Sophie Adèle")
                .customerEmail("t.sophie@gmail.com")
                .customerPhone("0102567890")
                .build();
        customerRepository.save(customer4);
        System.out.println(" Client crée : " + customer4.getCustomerName());

        Customer customer5 = Customer.builder()
                .customerName("Adama Konaté")
                .customerEmail("konateadama@gmail.com")
                .customerPhone("0504912345")
                .build();
        customerRepository.save(customer5);
        System.out.println(" Client crée : " + customer5.getCustomerName());

        Customer customer6 = Customer.builder()
                .customerName("Isabelle Bamba")
                .customerEmail("bamba.isabelle@gmail.com")
                .customerPhone("0102401234")
                .build();
        customerRepository.save(customer6);
        System.out.println(" Client crée : " + customer6.getCustomerName());

        Customer customer7 = Customer.builder()
                .customerName("Camille Tapé")
                .customerEmail("camilletape@gmail.com")
                .customerPhone("0103204567")
                .build();
        customerRepository.save(customer7);
        System.out.println(" Client crée : " + customer7.getCustomerName());

        Customer customer8 = Customer.builder()
                .customerName("Safré Emmanuel")
                .customerEmail("safking@gmail.com")
                .customerPhone("0505612345")
                .build();
        customerRepository.save(customer8);
        System.out.println(" Client crée : " + customer8.getCustomerName());

        Customer customer9 = Customer.builder()
                .customerName("N'goran Othniel")
                .customerEmail("othniel.ngoran@gmail.com")
                .customerPhone("0102473456")
                .build();
        customerRepository.save(customer9);
        System.out.println(" Client crée : " + customer9.getCustomerName());

        Customer customer10 = Customer.builder()
                .customerName("Baba Antoine")
                .customerEmail("antoine.baba@gmail.com")
                .customerPhone("0709671234")
                .build();
        customerRepository.save(customer10);
        System.out.println(" Client crée : " + customer10.getCustomerName());
    }
}
