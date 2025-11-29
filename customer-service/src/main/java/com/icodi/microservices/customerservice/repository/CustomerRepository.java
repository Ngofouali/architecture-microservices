package com.icodi.microservices.customerservice.repository;

import com.icodi.microservices.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCustomerEmail(String customerEmail);

    boolean existsByCustomerEmail(String customerEmail);

    //Cherche des clients par nom (recherche insensible à la casse)
    @Query("SELECT c FROM Customer c WHERE " +
            "LOWER(c.customerName) LIKE LOWER(CONCAT('%', :searchTerm, '%') ) "
    )
    List<Customer> searchByCustomerName(@Param("searchTerm") String searchTerm);

    List<Customer> findByCustomerPhone(String customerPhone);
}
