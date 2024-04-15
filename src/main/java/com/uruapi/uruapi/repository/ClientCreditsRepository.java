package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.ClientCredits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientCreditsRepository extends JpaRepository<ClientCredits, Long> {
}
