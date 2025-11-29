package com.icodi.microservices.inventoryservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Veuillez saisir un nom de produit")
    private String name;

    private String description;

    @NotBlank(message = "Veuillez saisir une référence unque")
    private String sku;

    @NotNull(message = "Veuillez insérer un prix")
    @Min(value = 0, message = "Le prix ne doit pas être négatif")
    private BigDecimal price;

    @NotNull(message = "Veuillez saisir la quantité en stock")
    @Min(value = 0, message = "Le prix ne peut être négatif")
    private Integer quantityInStock;

    private Integer minimumStockLevel;

    private String category;

    private Boolean getLowStock(){
        return minimumStockLevel != null && quantityInStock >= minimumStockLevel;
    };

    private Boolean getIsOutOfStock(){
        return quantityInStock != null && quantityInStock == 0;
    };
}
