package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.DistributorContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorContactRepository extends JpaRepository<DistributorContact, Long> {
}
