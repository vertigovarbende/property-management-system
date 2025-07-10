package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.Resident;
import com.deveyk.property_management.repository.ResidentRepository;
import com.deveyk.property_management.service.IResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentService implements IResidentService {

    @Autowired
    private ResidentRepository residentRepository;

    @Override
    public Resident saveResident(Resident resident) {
        return residentRepository.save(resident);
    }

    @Override
    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    @Override
    public Resident getResidentById(Long id) {
        Optional<Resident> residentOptional = residentRepository.findById(id);
        return residentOptional.orElse(null);
    }

    @Override
    public void deleteResidentById(Long id) {
        Resident dbResident = getResidentById(id);
        if (dbResident != null)
            residentRepository.delete(dbResident);
        else
            System.out.println("Resident not found");
    }

    @Override
    public Resident updateResidentById(Long id, Resident updateResident) {
        Resident dbResident = getResidentById(id);
        if (dbResident != null) {
            dbResident.setName(updateResident.getName());
            dbResident.setEmail(updateResident.getEmail());
            dbResident.setPhone(updateResident.getPhone());
            dbResident.setApartment(updateResident.getApartment());
            return residentRepository.save(dbResident);
        }
        return null;
    }
} 