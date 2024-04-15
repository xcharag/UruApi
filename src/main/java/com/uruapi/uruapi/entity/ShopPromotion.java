package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(
        name = "promotions",
        schema = "uru_db"
)
public class ShopPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromotion;

    private String name;
    private Float discount;
    private String validDate;
    private String expirationDate;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOrderDetail", referencedColumnName = "idOrderDetail")
    private OrderDetail orderDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idShop", referencedColumnName = "idShop")
    private Shop shop;
}
