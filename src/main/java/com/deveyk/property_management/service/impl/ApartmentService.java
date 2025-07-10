package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.Apartment;
import com.deveyk.property_management.repository.ApartmentRepository;
import com.deveyk.property_management.service.IApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService implements IApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Override
    public List<Apartment> getAllApartments() {
        List<Apartment> apartmentList = apartmentRepository.findAll();
        return apartmentList;
    }

    @Override
    public Apartment getApartmentById(Long id) {
        Optional<Apartment> apartmentOptional = apartmentRepository.findById(id);
        // or !apartmentOptional.isEmpty()
        if (apartmentOptional.isPresent()) {
            return apartmentOptional.get();
        }
        return null;
        // or we can do implementation functional way!
        // return apartmentOptional.orElse(null);
    }

    @Override
    public void deleteApartmentById(Long id) {
        Apartment dbApartment = getApartmentById(id);
        if (dbApartment != null)
            apartmentRepository.delete(dbApartment);
        else
            System.out.println("Apartment not found");
    }

    @Override
    public Apartment updateApartmentById(Long id, Apartment updateApartment) {
        Apartment dbApartment = getApartmentById(id);
        if (dbApartment != null) {
            dbApartment.setNumber(updateApartment.getNumber());
            dbApartment.setResident(updateApartment.getResident());

           return apartmentRepository.save(dbApartment);
        }
        return null;
    }

}
