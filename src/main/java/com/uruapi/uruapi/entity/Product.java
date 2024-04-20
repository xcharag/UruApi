package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "products"
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String name;
    private String description;
    private Float unitSellPrice;
    private String currency;
    private Float unitDiscount;
    private String publisher;
    private int minPlayers;
    private int maxPlayers;
    private int suggestedAge;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoryProduct", referencedColumnName = "idCategoryProduct")
    private CategoryProduct categoryProduct;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER)
    private List<ShopStock> shopStocks = new ArrayList<>();
}
