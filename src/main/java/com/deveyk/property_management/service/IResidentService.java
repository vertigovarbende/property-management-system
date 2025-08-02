package com.deveyk.property_management.service;

import com.deveyk.property_management.dto.DtoResident;
import com.deveyk.property_management.dto.iu.DtoResidentIU;

import java.util.List;

public interface IResidentService {

    public DtoResident saveResident(DtoResidentIU resident);

    public List<DtoResident> getAllResidents();

    public DtoResident getResidentById(Long id);

    public void deleteResidentById(Long id);

    public DtoResident updateResidentById(Long id, DtoResidentIU dtoResidentIU);
} 