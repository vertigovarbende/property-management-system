package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IResidentController;
import com.deveyk.property_management.entity.Resident;
import com.deveyk.property_management.service.IResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/resident")
public class ResidentController implements IResidentController {

    @Autowired
    private IResidentService residentService;

    @PostMapping("/save")
    @Override
    public Resident saveResident(@RequestBody Resident resident) {
        return residentService.saveResident(resident);
    }

    @GetMapping("/list")
    @Override
    public List<Resident> getAllResidents() {
        return residentService.getAllResidents();
    }

    @GetMapping("/list/{id}")
    @Override
    public Resident getResidentById(@PathVariable(name = "id") Long id) {
        return residentService.getResidentById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteResidentById(@PathVariable(name = "id") Long id) {
        residentService.deleteResidentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Resident updateResidentById(@PathVariable(name = "id") Long id,
                                       @RequestBody Resident updateResident) {
        return residentService.updateResidentById(id, updateResident);
    }
} 