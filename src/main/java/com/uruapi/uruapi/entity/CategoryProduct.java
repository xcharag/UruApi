package com.uruapi.uruapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(
        name = "category_product")
public class CategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoryProduct;

    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryProduct", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();
}
