package com.icodi.microservices.inventoryservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 200)
    private String name;

    @Column(length = 1000)
    private String description;
    /**
    * SKU (Stock Keeping Unit) - Référence Unique du produit*
     * Ex : "LAPTOP-DELL XPS-001*/
    @NotBlank(message = "Veuillez saisir une référence unque")
    @Column(nullable = false, unique = true, length = 50)
    private String sku;

    @NotNull(message = "Veuillez insérer un prix")
    @Min(value = 0, message = "Le prix ne doit pas être négatif")
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull(message = "Veuillez saisir la quantité en stock")
    @Min(value = 0, message = "Le prix ne peut être négatif")
    @Column(nullable = false, name = "quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "minimum_stock_level")
    private Integer minimumStockLevel;

    @Column(length = 100)
    private String category;

    /*
    * Vérifie si le stock est en dessous du seuil minimum
    * @return true si stock bas, false sinon
    * */
    public boolean isLowStock(){
        if(minimumStockLevel == null){
            return false;
        }
        return  quantityInStock <= minimumStockLevel;
    }

    /*
    * Vérifie si le produit est en rupture de stock
    * @return true si rupture, false sinon
    * */
    public boolean isOutOfStock(){
        return quantityInStock == 0;
    }
}
