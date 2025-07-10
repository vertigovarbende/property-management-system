package com.deveyk.property_management.repository;

import com.deveyk.property_management.entity.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixtureRepository extends JpaRepository<Fixture,Long> {
}
