package com.deveyk.property_management.repository;

import com.deveyk.property_management.entity.FixtureFeeShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixtureFeeShareRepository extends JpaRepository<FixtureFeeShare,Long> {
}
