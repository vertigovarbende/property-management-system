package com.deveyk.property_management.repository;

import com.deveyk.property_management.entity.Apartment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// or we can extend 'CrudRepository'
@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
