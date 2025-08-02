package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IApartmentController;
import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.iu.DtoApartmentIU;
import com.deveyk.property_management.service.IApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/apartment")
public class ApartmentController implements IApartmentController {

    @Autowired
    private IApartmentService apartmentService;

    @PostMapping("/save")
    @Override
    public DtoApartment saveApartment(@RequestBody DtoApartmentIU dtoApartmentIU) {
        return apartmentService.saveApartment(dtoApartmentIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoApartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoApartment  getApartmentById(@PathVariable(name = "id") Long id) {
        return apartmentService.getApartmentById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteApartmentById(@PathVariable(name = "id") Long id) {
        apartmentService.deleteApartmentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoApartment updateApartmentById(@PathVariable(name = "id") Long id,
                                         @RequestBody DtoApartmentIU dtoApartmentIU) {
        return apartmentService.updateApartmentById(id, dtoApartmentIU);
    }
}