package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "shop_personal",
        schema = "uru_db"
)
public class ShopPersonal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idShopPersonal;

    private String fullName;
    private String phoneNumber;
    private String email;
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idShop", referencedColumnName = "idShop")
    private Shop shop;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopPersonal", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();
}
