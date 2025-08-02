package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.DtoProperty;
import com.deveyk.property_management.dto.iu.DtoPropertyIU;
import com.deveyk.property_management.entity.Apartment;
import com.deveyk.property_management.entity.Property;
import com.deveyk.property_management.repository.ApartmentRepository;
import com.deveyk.property_management.repository.PropertyRepository;
import com.deveyk.property_management.service.IPropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyService implements IPropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    /*
    @Override
    public DtoProperty saveProperty(DtoPropertyIU dtoPropertyIU) {
        DtoProperty response = new DtoProperty();
        Property property = new Property();
        List<DtoApartment> dtoApartmentList = new ArrayList<>();
        Apartment apartment = new Apartment();

        try {
            BeanUtils.copyProperties(dtoPropertyIU, property);

            for (int i = 0; i < dtoPropertyIU.getDtoApartmentIds().size(); i++) {
                apartment = apartmentRepository.findById(dtoPropertyIU.getDtoApartmentIds().get(i))
                        .orElseThrow(() -> new RuntimeException("Apartment Not Found"));
                property.getApartments().add(apartment);
                DtoApartment dtoApartment = new DtoApartment();
                BeanUtils.copyProperties(apartment, dtoApartment);
                dtoApartmentList.add(dtoApartment);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        Property dbProperty = propertyRepository.save(property);
        BeanUtils.copyProperties(dbProperty, response);
        response.setApartmentList(dtoApartmentList);
        return response;
    }
    */


    @Override
    public DtoProperty saveProperty(DtoPropertyIU dtoPropertyIU) {
        DtoProperty response = new DtoProperty();
        Property property = new Property();
        List<DtoApartment> dtoApartmentList = new ArrayList<>();

        try {
            BeanUtils.copyProperties(dtoPropertyIU, property);

            for (int i = 0; i < dtoPropertyIU.getDtoApartmentIds().size(); i++) {
                Apartment apartment = apartmentRepository.findById(dtoPropertyIU.getDtoApartmentIds().get(i))
                        .orElseThrow(() -> new RuntimeException("Apartment Not Found"));

                property.getApartments().add(apartment);

                DtoApartment dtoApartment = new DtoApartment();
                BeanUtils.copyProperties(apartment, dtoApartment);
                dtoApartmentList.add(dtoApartment);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        Property dbProperty = propertyRepository.save(property);
        BeanUtils.copyProperties(dbProperty, response);
        response.setApartmentList(dtoApartmentList);
        return response;
    }

    @Override
    public List<DtoProperty> getAllProperties() {
        List<DtoProperty> dtoPropertyList = new ArrayList<>();
        List<Property> propertyList = propertyRepository.findAll();
        List<DtoApartment> dtoApartmentList = new ArrayList<>();

        for (Property property : propertyList) {
            DtoProperty dtoProperty = new DtoProperty();
            for (Apartment apartment:  property.getApartments()) {
                DtoApartment dtoApartment = new DtoApartment();
                BeanUtils.copyProperties(apartment, dtoApartment);
                dtoApartmentList.add(dtoApartment);
            }
            BeanUtils.copyProperties(property, dtoProperty);
            dtoProperty.setApartmentList(dtoApartmentList);

            dtoPropertyList.add(dtoProperty);
        }
        return dtoPropertyList;
    }

    @Override
    public DtoProperty getPropertyById(Long id) {
        DtoProperty dtoProperty = new DtoProperty();
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        if (propertyOptional.isPresent()) {
            Property dbProperty = propertyOptional.get();
            BeanUtils.copyProperties(dbProperty, dtoProperty);
            return dtoProperty;
        }
        return null;
    }

    @Override
    public void deletePropertyById(Long id) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);
        propertyOptional.ifPresent(property -> propertyRepository.delete(property));
    }

    @Override
    public DtoProperty updatePropertyById(Long id, DtoPropertyIU dtoPropertyIU) {
        Optional<Property> propertyOptional = propertyRepository.findById(id);

        if (propertyOptional.isPresent()) {
            Property dbProperty = propertyOptional.get();

            dbProperty.setAddress(dtoPropertyIU.getAddress());
            dbProperty.setName(dtoPropertyIU.getName());

            Property updatedProperty = propertyRepository.save(dbProperty);
            DtoProperty dtoProperty = new DtoProperty();
            BeanUtils.copyProperties(updatedProperty, dtoProperty);
            return dtoProperty;
        }
        return null;
    }
} 