package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "shops",
        schema = "uru_db"
)
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShop;

    private String name;
    private String address;
    private Boolean status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop", fetch = FetchType.EAGER)
    private List<ShopPersonal> shopPersonals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop", fetch = FetchType.EAGER)
    private List<ShopPromotion> shopPromotions = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop", fetch = FetchType.EAGER)
    private List<ShopStock> shopStocks = new ArrayList<>();
}
