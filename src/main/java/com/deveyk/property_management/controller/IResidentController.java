package com.deveyk.property_management.controller;

import com.deveyk.property_management.entity.Resident;
import java.util.List;

public interface IResidentController {

    public Resident saveResident(Resident resident);

    public List<Resident> getAllResidents();

    public Resident getResidentById(Long id);

    public void deleteResidentById(Long id);

    public Resident updateResidentById(Long id, Resident updateResident);
} 