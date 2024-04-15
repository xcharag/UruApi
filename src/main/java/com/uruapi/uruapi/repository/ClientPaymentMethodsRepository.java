package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.ClientPaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPaymentMethodsRepository extends JpaRepository<ClientPaymentMethods, Long> {
}
