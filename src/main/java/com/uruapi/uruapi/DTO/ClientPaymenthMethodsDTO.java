package com.uruapi.uruapi.DTO;

import lombok.Data;

@Data
public class ClientPaymenthMethodsDTO {
    private Long id;
    private Long idClient;
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private String cardHolder;
}
