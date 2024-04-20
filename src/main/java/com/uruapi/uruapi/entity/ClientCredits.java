package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "client_credits"
)
public class ClientCredits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientCredits;

    private Float quantity;
    private String currency;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;
}
