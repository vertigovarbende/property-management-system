package com.deveyk.property_management.repository;

import com.deveyk.property_management.entity.FixtureFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixtureFeeRepository extends JpaRepository<FixtureFee, Long> {
}
