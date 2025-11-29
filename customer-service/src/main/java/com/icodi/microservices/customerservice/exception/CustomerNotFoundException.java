package com.icodi.microservices.customerservice.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Client avec l'id " + id + "introuvable");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
