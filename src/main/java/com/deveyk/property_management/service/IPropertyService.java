package com.deveyk.property_management.service;

import com.deveyk.property_management.entity.Property;
import java.util.List;

public interface IPropertyService {

    public Property saveProperty(Property property);

    public List<Property> getAllProperties();

    public Property getPropertyById(Long id);

    public void deletePropertyById(Long id);

    public Property updatePropertyById(Long id, Property updateProperty);
} 