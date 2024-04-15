package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.ClientPhoneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientPhoneNumbersRepository extends JpaRepository<ClientPhoneNumbers, Long> {
}
