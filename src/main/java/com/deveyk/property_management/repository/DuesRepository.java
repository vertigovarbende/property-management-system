package com.deveyk.property_management.repository;

import com.deveyk.property_management.entity.Dues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuesRepository extends JpaRepository<Dues, Long> {

}
