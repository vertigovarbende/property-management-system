package com.deveyk.property_management.controller;

import com.deveyk.property_management.entity.Property;
import java.util.List;

public interface IPropertyController {

    public Property saveProperty(Property property);

    public List<Property> getAllProperties();

    public Property getPropertyById(Long id);

    public void deletePropertyById(Long id);

    public Property updatePropertyById(Long id, Property updateProperty);
} 