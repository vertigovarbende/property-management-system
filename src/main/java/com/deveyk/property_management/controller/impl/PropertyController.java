package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IPropertyController;
import com.deveyk.property_management.entity.Property;
import com.deveyk.property_management.service.IPropertyService;
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
    public Property saveProperty(@RequestBody Property property) {
        return propertyService.saveProperty(property);
    }

    @GetMapping("/list")
    @Override
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/list/{id}")
    @Override
    public Property getPropertyById(@PathVariable(name = "id") Long id) {
        return propertyService.getPropertyById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deletePropertyById(@PathVariable(name = "id") Long id) {
        propertyService.deletePropertyById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Property updatePropertyById(@PathVariable(name = "id") Long id,
                                       @RequestBody Property updateProperty) {
        return propertyService.updatePropertyById(id, updateProperty);
    }
} 