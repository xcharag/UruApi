package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.ShopStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopStockRepository extends JpaRepository<ShopStock, Long> {
}
