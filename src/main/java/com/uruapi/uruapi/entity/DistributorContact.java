package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "distributor_contacts",
        schema = "uru_db"
)
public class DistributorContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistributorContact;

    private String phoneNumber;
    private String email;
    private String contactName;
    private String contactRole;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDistributor",referencedColumnName = "idDistributor")
    private Distributor distributor;
}
