package com.uruapi.uruapi.repository;

import com.uruapi.uruapi.entity.EnumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnumRoleRepository extends JpaRepository<EnumRole, Long> {
}
