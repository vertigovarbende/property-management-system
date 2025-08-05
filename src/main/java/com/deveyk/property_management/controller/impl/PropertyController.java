package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IPropertyController;
import com.deveyk.property_management.dto.DtoProperty;
import com.deveyk.property_management.dto.iu.DtoPropertyIU;
import com.deveyk.property_management.entity.Property;
import com.deveyk.property_management.service.IPropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/property")
public class PropertyController implements IPropertyController {

    @Autowired
    private IPropertyService propertyService;

    @PostMapping("/save")
    @Override
    public DtoProperty saveProperty(@RequestBody @Valid DtoPropertyIU dtoPropertyIU) {
        return propertyService.saveProperty(dtoPropertyIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoProperty> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoProperty getPropertyById(@PathVariable(name = "id") Long id) {
        return propertyService.getPropertyById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deletePropertyById(@PathVariable(name = "id") Long id) {
        propertyService.deletePropertyById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoProperty updatePropertyById(@PathVariable(name = "id") Long id,
                                       @RequestBody @Valid DtoPropertyIU dtoPropertyIU) {
        return propertyService.updatePropertyById(id, dtoPropertyIU);
    }
} 