package com.icodi.microservices.customerservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Veuillez saisir un prénom")
    private String customerName;

    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "Veuillez saisir un email valide")
    private String customerEmail;

    @NotBlank(message = "Veuillez saisir un numéro de téléphone")
    private String customerPhone;
}
