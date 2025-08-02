package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IResidentController;
import com.deveyk.property_management.dto.DtoResident;
import com.deveyk.property_management.dto.iu.DtoResidentIU;
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
    public DtoResident saveResident(@RequestBody DtoResidentIU dtoResidentIU) {
        return residentService.saveResident(dtoResidentIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoResident> getAllResidents() {
        return residentService.getAllResidents();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoResident getResidentById(@PathVariable(name = "id") Long id) {
        return residentService.getResidentById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteResidentById(@PathVariable(name = "id") Long id) {
        residentService.deleteResidentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoResident updateResidentById(@PathVariable(name = "id") Long id,
                                       @RequestBody DtoResidentIU dtoResidentIU) {
        return residentService.updateResidentById(id, dtoResidentIU);
    }
} 