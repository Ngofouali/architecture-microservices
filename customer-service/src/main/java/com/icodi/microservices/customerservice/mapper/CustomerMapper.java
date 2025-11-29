package com.icodi.microservices.customerservice.mapper;

import com.icodi.microservices.customerservice.dto.CustomerDTO;
import com.icodi.microservices.customerservice.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> customerListToCustomerDTOList(List<Customer> customerList);

        // Mettre à jour une entité existante avec les données d'un DTO
    void updateCustomerFromCustomerDTO(CustomerDTO customerDTO, @MappingTarget Customer customer);
}
