package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "stocks"
)
public class ShopStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;

    private int quantity;
    private Float buyPrice;
    private String buyDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idShop",referencedColumnName = "idShop")
    private Shop shop;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDistributor",referencedColumnName = "idDistributor")
    private Distributor distributor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct",referencedColumnName = "idProduct")
    private Product product;
}
