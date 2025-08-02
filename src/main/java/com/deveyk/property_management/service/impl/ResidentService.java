package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.DtoResident;
import com.deveyk.property_management.dto.iu.DtoResidentIU;
import com.deveyk.property_management.entity.Apartment;
import com.deveyk.property_management.entity.Resident;
import com.deveyk.property_management.repository.ApartmentRepository;
import com.deveyk.property_management.repository.ResidentRepository;
import com.deveyk.property_management.service.IResidentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResidentService implements IResidentService {

    @Autowired
    private ResidentRepository residentRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public DtoResident saveResident(DtoResidentIU dtoResidentIU) {
        DtoResident response = new DtoResident();
        Resident resident = new Resident();
        // if there is no apartment with specified id, then throw RunTimeException
        try {
            Apartment apartment = apartmentRepository.findById(dtoResidentIU.getDtoApartmentId())
                    .orElseThrow(() -> new RuntimeException("Apartment not found"));
            resident.setApartment(apartment);
            apartment.setResident(resident);
            BeanUtils.copyProperties(dtoResidentIU, resident);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        Resident dbResident = residentRepository.save(resident);
        BeanUtils.copyProperties(dbResident, response);

        return response;
    }

    @Override
    public List<DtoResident> getAllResidents() {
        List<DtoResident> dtoResidentList = new ArrayList<>();
        List<Resident> residentList = residentRepository.findAll();

        for (Resident resident : residentList) {
            DtoResident dtoResident = new DtoResident();
            Apartment apartment = resident.getApartment();

            DtoApartment dtoApartment = new DtoApartment();
            BeanUtils.copyProperties(apartment, dtoApartment);

            BeanUtils.copyProperties(resident, dtoResident);
            dtoResident.setApartment(dtoApartment);

            dtoResidentList.add(dtoResident);
        }

        return dtoResidentList;
    }

    @Override
    public DtoResident getResidentById(Long id) {
        DtoResident dtoResident = new DtoResident();
        Optional<Resident> residentOptional = residentRepository.findById(id);

        if (residentOptional.isPresent()) {
            Resident dbResident = residentOptional.get();

            Apartment apartment = dbResident.getApartment();

            DtoApartment dtoApartment = new DtoApartment();
            if (apartment != null) {
                BeanUtils.copyProperties(apartment, dtoApartment);
            }

            BeanUtils.copyProperties(dbResident, dtoResident);
            dtoResident.setApartment(dtoApartment);

            return dtoResident;
        }

        return null;
    }

    @Override
    public void deleteResidentById(Long id) {
        Optional<Resident> residentOptional = residentRepository.findById(id);
        residentOptional.ifPresent(resident -> residentRepository.delete(resident));
    }

    @Override
    public DtoResident updateResidentById(Long id, DtoResidentIU dtoResidentIU) {
        Optional<Resident> residentOptional = residentRepository.findById(id);
        DtoResident dtoResident = new DtoResident();
        if (residentOptional.isPresent()) {
            Resident dbResident = residentOptional.get();

            dbResident.setName(dtoResidentIU.getName());
            dbResident.setType(dtoResidentIU.getType());
            dbResident.setPhone(dtoResidentIU.getPhone());
            dbResident.setEmail(dtoResidentIU.getEmail());

            Optional<Apartment> apartmentOptional = apartmentRepository.findById(dtoResidentIU.getDtoApartmentId());
            if (apartmentOptional.isPresent()) {
                dbResident.setApartment(apartmentOptional.get());
                Apartment apartment = apartmentRepository.findById(dtoResidentIU.getDtoApartmentId()).get();
                apartment.setResident(dbResident);
            }

            Resident updatedResident = residentRepository.save(dbResident);
            BeanUtils.copyProperties(updatedResident, dtoResident);

            return dtoResident;
        }
        return null;
    }
} 