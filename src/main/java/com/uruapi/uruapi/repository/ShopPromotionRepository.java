package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.ShopPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopPromotionRepository extends JpaRepository<ShopPromotion, Long> {
}
