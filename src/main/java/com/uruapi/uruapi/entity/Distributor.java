package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "distributors",
        schema = "uru_db"
)
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDistributor;

    private String name;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distributor", fetch = FetchType.EAGER)
    private List<ShopStock> shopStocks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "distributor", fetch = FetchType.EAGER)
    private List<DistributorContact> distributorContacts = new ArrayList<>();
}
