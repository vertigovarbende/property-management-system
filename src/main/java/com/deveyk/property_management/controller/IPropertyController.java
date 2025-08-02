package com.deveyk.property_management.controller;

import com.deveyk.property_management.dto.DtoProperty;
import com.deveyk.property_management.dto.iu.DtoPropertyIU;
import com.deveyk.property_management.entity.Property;
import java.util.List;

public interface IPropertyController {

    public DtoProperty saveProperty(DtoPropertyIU dtoPropertyIU);

    public List<DtoProperty> getAllProperties();

    public DtoProperty getPropertyById(Long id);

    public void deletePropertyById(Long id);

    public DtoProperty updatePropertyById(Long id, DtoPropertyIU dtoPropertyIU);
} 