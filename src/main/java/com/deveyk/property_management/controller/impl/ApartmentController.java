package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IApartmentController;
import com.deveyk.property_management.entity.Apartment;
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
    public Apartment saveApartment(@RequestBody Apartment apartment) {
        return apartmentService.saveApartment(apartment);
    }

    @GetMapping("/list")
    @Override
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/list/{id}")
    @Override
    public Apartment  getApartmentById(@PathVariable(name = "id") Long id) {
        return apartmentService.getApartmentById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteApartmentById(@PathVariable(name = "id") Long id) {
        apartmentService.deleteApartmentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Apartment updateApartmentById(@PathVariable(name = "id") Long id,
                                         @RequestBody Apartment updateApartment) {
        return apartmentService.updateApartmentById(id, updateApartment);
    }
}
