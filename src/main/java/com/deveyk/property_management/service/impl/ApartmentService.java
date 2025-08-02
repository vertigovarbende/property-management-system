package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.iu.DtoApartmentIU;
import com.deveyk.property_management.dto.DtoResident;
import com.deveyk.property_management.entity.Apartment;
import com.deveyk.property_management.entity.Resident;
import com.deveyk.property_management.repository.ApartmentRepository;
import com.deveyk.property_management.repository.ResidentRepository;
import com.deveyk.property_management.service.IApartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService implements IApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public DtoApartment saveApartment(DtoApartmentIU dtoApartmentIU) {
        DtoApartment response = new DtoApartment();
        Apartment apartment = new Apartment();
        // if there is no resident with specified id, then throw RunTimeException
        try {
            Resident resident = residentRepository.findById(dtoApartmentIU.getResidentId())
                    .orElseThrow(() -> new RuntimeException("Resident not found"));
            apartment.setResident(resident);
            BeanUtils.copyProperties(dtoApartmentIU, apartment);
            dtoApartmentIU.setResidentId(resident.getId());
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }

        Apartment dbApartment = apartmentRepository.save(apartment);
        BeanUtils.copyProperties(dbApartment, response);

        return response;
    }

    @Override
    public List<DtoApartment> getAllApartments() {
        List<DtoApartment> dtoApartmentList = new ArrayList<>();
        List<Apartment> apartmentList = apartmentRepository.findAll();
        DtoResident dtoResident = new DtoResident();
        for (Apartment apartment : apartmentList) {
            DtoApartment dtoApartment = new DtoApartment();
            BeanUtils.copyProperties(apartment, dtoApartment);
            dtoResident.setApartment(dtoApartment);
            dtoApartmentList.add(dtoApartment);
        }
        return dtoApartmentList;
    }

    @Override
    public DtoApartment getApartmentById(Long id) {
        DtoApartment dtoApartment = new DtoApartment();
        Optional<Apartment> apartmentOptional = apartmentRepository.findById(id);
        // or !apartmentOptional.isEmpty()
        if (apartmentOptional.isPresent()) {
            Apartment dbApartment = apartmentOptional.get();
            BeanUtils.copyProperties(dbApartment, dtoApartment);
            return dtoApartment;
        }
        return null;
        // or we can do implementation functional way!
        // return apartmentOptional.orElse(null);
    }

    @Override
    public void deleteApartmentById(Long id) {
        Optional<Apartment> apartmentOptional = apartmentRepository.findById(id);
        apartmentOptional.ifPresent(apartment -> apartmentRepository.delete(apartment));
    }

    @Override
    public DtoApartment updateApartmentById(Long id, DtoApartmentIU dtoApartmentIU) {
        Optional<Apartment> apartmentOptional = apartmentRepository.findById(id);
        DtoApartment dtoApartment = new DtoApartment();
        if (apartmentOptional.isPresent()) {
            Apartment dbApartment = apartmentOptional.get();

            dbApartment.setNumber(dtoApartmentIU.getNumber());
            dbApartment.setType(dtoApartmentIU.getType());
            dbApartment.setAllotmentPercentage(dtoApartmentIU.getAllotmentPercentage());

            Optional<Resident> residentOptional =  residentRepository.findById(dtoApartmentIU.getResidentId());
            if (residentOptional.isPresent()) {
                dbApartment.setResident(residentOptional.get());
            }

            Apartment updatedApartment = apartmentRepository.save(dbApartment);
            BeanUtils.copyProperties(updatedApartment, dtoApartment);
            return dtoApartment;
        }
        return null;
    }
}