package com.deveyk.property_management.service;

import com.deveyk.property_management.entity.Apartment;

import java.util.List;

public interface IApartmentService {

    public Apartment saveApartment(Apartment apartment);

    public List<Apartment> getAllApartments();

    public Apartment getApartmentById(Long id);

    public void deleteApartmentById(Long id);

    public Apartment updateApartmentById(Long id, Apartment updateApartment);
}
