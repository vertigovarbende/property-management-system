package com.deveyk.property_management.repository;

import com.deveyk.property_management.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident,Long> {
}
