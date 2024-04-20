package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "order_details"
)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderDetail;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOrder", referencedColumnName = "idOrder")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct")
    private Product product;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderDetail", fetch = FetchType.EAGER)
    private List<ShopPromotion> shopPromotions = new ArrayList<>();
}
