package com.icodi.microservices.customerservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Veuillez saisir un prénom")
    @Column(nullable = false, length =150)
    private String customerName;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Veuillez saisir un email valide")
    @Column(nullable = false, unique = true, length = 150)
    private String customerEmail;

    @NotBlank(message = "Veuillez saisir un numéro de téléphone")
    @Column(length = 20)
    private String customerPhone;
}
