package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoFixture;
import com.deveyk.property_management.dto.DtoProperty;
import com.deveyk.property_management.dto.iu.DtoFixtureIU;
import com.deveyk.property_management.entity.Fixture;
import com.deveyk.property_management.entity.Property;
import com.deveyk.property_management.repository.FixtureRepository;
import com.deveyk.property_management.repository.PropertyRepository;
import com.deveyk.property_management.service.IFixtureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FixtureService implements IFixtureService {

    @Autowired
    private FixtureRepository fixtureRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public DtoFixture saveFixture(DtoFixtureIU dtoFixtureIU) {
        DtoFixture response = new DtoFixture();
        Fixture fixture = new Fixture();

        try {
            BeanUtils.copyProperties(dtoFixtureIU, fixture);
            Property property = propertyRepository.findById(dtoFixtureIU.getDtoPropertyId())
                    .orElseThrow(() -> new RuntimeException("Property Not Found"));
            fixture.setProperty(property);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        Fixture dbFixture = fixtureRepository.save(fixture);

        BeanUtils.copyProperties(dbFixture, response);

        DtoProperty dtoProperty = new DtoProperty();
        BeanUtils.copyProperties(dbFixture.getProperty(), dtoProperty);
        response.setDtoProperty(dtoProperty);

        return response;
    }

    @Override
    public List<DtoFixture> getAllFixtures() {
        List<DtoFixture> dtoFixtureList = new ArrayList<>();
        List<Fixture> fixtureList = fixtureRepository.findAll();

        for (Fixture fixture : fixtureList) {
            DtoFixture dtoFixture = new DtoFixture();
            Property property = fixture.getProperty();

            DtoProperty dtoProperty = new DtoProperty();
            BeanUtils.copyProperties(property, dtoProperty);

            BeanUtils.copyProperties(fixture, dtoFixture);
            dtoFixture.setDtoProperty(dtoProperty);

            dtoFixtureList.add(dtoFixture);
        }
        return dtoFixtureList;
    }

    @Override
    public DtoFixture getFixtureById(Long id) {
        DtoFixture dtoFixture = new DtoFixture();
        Optional<Fixture> fixtureOptional = fixtureRepository.findById(id);

        if (fixtureOptional.isPresent()) {
            Fixture dbFixture = fixtureOptional.get();

            Property property = dbFixture.getProperty();
            DtoProperty dtoProperty  = new DtoProperty();
            if (property != null) {
                BeanUtils.copyProperties(property, dtoProperty);
            }

            BeanUtils.copyProperties(dbFixture, dtoFixture);
            dtoFixture.setDtoProperty(dtoProperty);
            return dtoFixture;
        }
        return null;
    }

    @Override
    public void deleteFixtureById(Long id) {
        Optional<Fixture> fixtureOptional = fixtureRepository.findById(id);
        fixtureOptional.ifPresent(fixture -> fixtureRepository.delete(fixture));
    }

    @Override
    public DtoFixture updateFixtureById(Long id, DtoFixtureIU dtoFixtureIU) {
        Optional<Fixture> fixtureOptional = fixtureRepository.findById(id);

        if (fixtureOptional.isPresent()) {
            Fixture dbFixture = fixtureOptional.get();

            dbFixture.setFixtureName(dtoFixtureIU.getFixtureName());
            dbFixture.setDescription(dtoFixtureIU.getDescription());

            Optional<Property> propertyOptional =  propertyRepository.findById(dtoFixtureIU.getDtoPropertyId());
            if (propertyOptional.isPresent()) {
                dbFixture.setProperty(propertyOptional.get());
            }

            DtoProperty dtoProperty = new DtoProperty();
            BeanUtils.copyProperties(dbFixture.getProperty(), dtoProperty);

            Fixture updatedFixture = fixtureRepository.save(dbFixture);

            DtoFixture dtoFixture = new DtoFixture();
            BeanUtils.copyProperties(updatedFixture, dtoFixture);
            dtoFixture.setDtoProperty(dtoProperty);
            return dtoFixture;
        }
        return null;
    }
} 