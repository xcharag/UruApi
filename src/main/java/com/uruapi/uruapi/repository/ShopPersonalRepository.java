package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.ShopPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopPersonalRepository extends JpaRepository<ShopPersonal, Long> {
}
