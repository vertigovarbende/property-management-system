package com.deveyk.property_management.service;

import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.iu.DtoApartmentIU;

import java.util.List;

public interface IApartmentService {

    public DtoApartment saveApartment(DtoApartmentIU dtoApartmentIU);

    public List<DtoApartment> getAllApartments();

    public DtoApartment getApartmentById(Long id);

    public void deleteApartmentById(Long id);

    public DtoApartment updateApartmentById(Long id, DtoApartmentIU dtoApartmentIU);
}
