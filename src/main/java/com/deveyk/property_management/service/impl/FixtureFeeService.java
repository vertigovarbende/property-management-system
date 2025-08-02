package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoFixture;
import com.deveyk.property_management.dto.DtoFixtureFee;
import com.deveyk.property_management.dto.DtoProperty;
import com.deveyk.property_management.dto.iu.DtoFixtureFeeIU;
import com.deveyk.property_management.entity.Fixture;
import com.deveyk.property_management.entity.FixtureFee;
import com.deveyk.property_management.entity.Property;
import com.deveyk.property_management.repository.FixtureFeeRepository;
import com.deveyk.property_management.repository.FixtureRepository;
import com.deveyk.property_management.service.IFixtureFeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FixtureFeeService implements IFixtureFeeService {

    @Autowired
    private FixtureFeeRepository fixtureFeeRepository;
    @Autowired
    private FixtureRepository fixtureRepository;

    @Override
    public DtoFixtureFee saveFixtureFee(DtoFixtureFeeIU dtoFixtureFeeIU) {
        DtoFixtureFee response = new DtoFixtureFee();
        FixtureFee fixtureFee = new FixtureFee();

        try {
            BeanUtils.copyProperties(dtoFixtureFeeIU, fixtureFee);
            Fixture fixture = fixtureRepository.findById(dtoFixtureFeeIU.getDtoFixtureId())
                    .orElseThrow(() -> new RuntimeException("Fixture Not Found"));
            fixtureFee.setFixture(fixture);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        FixtureFee dbFixtureFee = fixtureFeeRepository.save(fixtureFee);

        BeanUtils.copyProperties(dbFixtureFee, response);

        DtoFixture dtoFixture = new DtoFixture();
        BeanUtils.copyProperties(dbFixtureFee.getFixture(), dtoFixture);

        DtoProperty dtoProperty = new DtoProperty();
        Property property = dbFixtureFee.getFixture().getProperty();
        BeanUtils.copyProperties(property, dtoProperty);

        response.setDtoFixture(dtoFixture);
        response.getDtoFixture().setDtoProperty(dtoProperty);

        return response;
    }

    @Override
    public List<DtoFixtureFee> getAllFixtureFees() {
        List<DtoFixtureFee> dtoFixtureFeeList = new ArrayList<>();
        List<FixtureFee> fixtureFeeList = fixtureFeeRepository.findAll();

        for (FixtureFee fixtureFee : fixtureFeeList) {
            DtoFixtureFee dtoFixtureFee = new DtoFixtureFee();
            Fixture fixture = fixtureFee.getFixture();

            DtoFixture dtoFixture = new DtoFixture();
            BeanUtils.copyProperties(fixture, dtoFixture);

            DtoProperty dtoProperty = new DtoProperty();
            Property property = fixtureFee.getFixture().getProperty();
            BeanUtils.copyProperties(property, dtoProperty);

            BeanUtils.copyProperties(fixtureFee, dtoFixtureFee);
            dtoFixtureFee.setDtoFixture(dtoFixture);
            dtoFixtureFee.getDtoFixture().setDtoProperty(dtoProperty);

            dtoFixtureFeeList.add(dtoFixtureFee);
        }
        return dtoFixtureFeeList;
    }

    @Override
    public DtoFixtureFee getFixtureFeeById(Long id) {
        DtoFixtureFee dtoFixtureFee =  new DtoFixtureFee();
        Optional<FixtureFee> fixtureFeeOptional = fixtureFeeRepository.findById(id);

        if (fixtureFeeOptional.isPresent()) {
            FixtureFee dbFixtureFee = fixtureFeeOptional.get();

            Fixture fixture = dbFixtureFee.getFixture();
            DtoFixture dtoFixture = new DtoFixture();
            if (fixture != null) {
                BeanUtils.copyProperties(fixture, dtoFixture);
            }

            Property property = dbFixtureFee.getFixture().getProperty();
            DtoProperty dtoProperty = new DtoProperty();
            if (property != null) {
                BeanUtils.copyProperties(property, dtoProperty);
            }

            BeanUtils.copyProperties(dbFixtureFee, dtoFixtureFee);
            dtoFixtureFee.setDtoFixture(dtoFixture);
            dtoFixtureFee.getDtoFixture().setDtoProperty(dtoProperty);
            return dtoFixtureFee;
        }
        return null;
    }

    @Override
    public void deleteFixtureFeeById(Long id) {
        Optional<FixtureFee> fixtureFeeOptional = fixtureFeeRepository.findById(id);
        fixtureFeeOptional.ifPresent(fixtureFee -> fixtureFeeRepository.delete(fixtureFee));
    }

    @Override
    public DtoFixtureFee updateFixtureFeeById(Long id, DtoFixtureFeeIU dtoFixtureFeeIU) {
        Optional<FixtureFee> fixtureFeeOptional = fixtureFeeRepository.findById(id);

        if (fixtureFeeOptional.isPresent()) {
            FixtureFee dbFixtureFee = fixtureFeeOptional.get();

            dbFixtureFee.setTotalAmount(dtoFixtureFeeIU.getTotalAmount());
            dbFixtureFee.setDate(dtoFixtureFeeIU.getDate());
            dbFixtureFee.setDescription(dtoFixtureFeeIU.getDescription());

            Optional<Fixture> fixtureOptional = fixtureRepository.findById(dbFixtureFee.getFixture().getId());
            if  (fixtureOptional.isPresent()) {
                dbFixtureFee.setFixture(fixtureOptional.get());
            }

            DtoFixture dtoFixture = new DtoFixture();
            BeanUtils.copyProperties(dbFixtureFee.getFixture(), dtoFixture);

            DtoProperty dtoProperty = new DtoProperty();
            Property property = dbFixtureFee.getFixture().getProperty();
            BeanUtils.copyProperties(property, dtoProperty);

            FixtureFee updatedFixtureFee = fixtureFeeRepository.save(dbFixtureFee);

            DtoFixtureFee dtoFixtureFee = new DtoFixtureFee();
            BeanUtils.copyProperties(updatedFixtureFee, dtoFixtureFee);
            dtoFixtureFee.setDtoFixture(dtoFixture);
            dtoFixtureFee.getDtoFixture().setDtoProperty(dtoProperty);
            return dtoFixtureFee;
        }
        return null;
    }
} 