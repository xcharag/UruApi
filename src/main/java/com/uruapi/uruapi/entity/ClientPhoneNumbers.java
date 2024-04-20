package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "client_phone_numbers"
)
public class ClientPhoneNumbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumber;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;
}
