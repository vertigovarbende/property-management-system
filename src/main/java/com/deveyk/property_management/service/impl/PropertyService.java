package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.Property;
import com.deveyk.property_management.repository.PropertyRepository;
import com.deveyk.property_management.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Property saveProperty(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        return propertyOptional.orElse(null);
    }

    @Override
    public void deletePropertyById(Long id) {
        Property dbProperty = getPropertyById(id);
        if (dbProperty != null)
            propertyRepository.delete(dbProperty);
        else
            System.out.println("Property not found");
    }

    @Override
    public Property updatePropertyById(Long id, Property updateProperty) {
        Property dbProperty = getPropertyById(id);
        if (dbProperty != null) {
            dbProperty.setName(updateProperty.getName());
            dbProperty.setAddress(updateProperty.getAddress());
            return propertyRepository.save(dbProperty);
        }
        return null;
    }
} 