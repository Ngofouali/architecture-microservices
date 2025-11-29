package com.icodi.microservices.inventoryservice.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Le produit avec l'id " + id + " introuvable");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

}
