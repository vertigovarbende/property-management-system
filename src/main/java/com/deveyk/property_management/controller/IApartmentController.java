package com.deveyk.property_management.controller;

import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.iu.DtoApartmentIU;

import java.util.List;

public interface IApartmentController {

    public DtoApartment saveApartment(DtoApartmentIU dtoApartmentIU);

    public List<DtoApartment> getAllApartments();

    public DtoApartment getApartmentById(Long id);

    public void deleteApartmentById(Long id);

    public DtoApartment updateApartmentById(Long id, DtoApartmentIU dtoApartmentIU);
}
