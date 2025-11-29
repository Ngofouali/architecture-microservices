package com.icodi.microservices.inventoryservice.repository;

import com.icodi.microservices.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBysku(String sku);

    boolean existsBySku(String sku);

    List<Product> findByCategory(String category);

    @Query("SELECT p FROM Product p WHERE p.quantityInStock <= p.minimumStockLevel")
    List<Product> findLowStockProducts();

    @Query("SELECT p FROM Product p WHERE p.quantityInStock = 0")
    List<Product> findOutOfStockProducts();

    // Recherche de produits par nom, sku ou catégorie
    @Query("SELECT p FROM Product p WHERE " +
    "LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
    "LOWER(p.sku) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
    "LOWER(p.category) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Product> searchProducts(@Param("searchTerm") String searchTerm);

    // Compte les produits par catégorie
    @Query("SELECT p.category, COUNT(p) FROM Product p GROUP BY p.category")
    List<Object[]> countByCategory(String category);
}
