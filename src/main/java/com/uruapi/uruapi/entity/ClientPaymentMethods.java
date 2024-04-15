package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "client_payment_methods",
        schema = "uru_db"
)
public class ClientPaymentMethods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientPaymentMethod;

    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private String cardHolderName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;
}
