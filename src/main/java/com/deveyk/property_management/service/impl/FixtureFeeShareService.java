package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.*;
import com.deveyk.property_management.dto.iu.DtoFixtureFeeShareIU;
import com.deveyk.property_management.entity.*;
import com.deveyk.property_management.repository.ApartmentRepository;
import com.deveyk.property_management.repository.FixtureFeeRepository;
import com.deveyk.property_management.repository.FixtureFeeShareRepository;
import com.deveyk.property_management.service.IFixtureFeeShareService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.DocumentationTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FixtureFeeShareService implements IFixtureFeeShareService {

    @Autowired
    private FixtureFeeShareRepository fixtureFeeShareRepository;
    @Autowired
    private FixtureFeeRepository fixtureFeeRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public DtoFixtureFeeShare saveFixtureFeeShare(DtoFixtureFeeShareIU dtoFixtureFeeShareIU) {
        DtoFixtureFeeShare response = new DtoFixtureFeeShare();
        FixtureFeeShare fixtureFeeShare = new FixtureFeeShare();

        try {
            BeanUtils.copyProperties(dtoFixtureFeeShareIU, fixtureFeeShare);
            FixtureFee fixtureFee = fixtureFeeRepository.findById(dtoFixtureFeeShareIU.getDtoFixtureFeeId())
                    .orElseThrow(() -> new RuntimeException("Fixture Fee Not Found"));
            fixtureFeeShare.setFixtureFee(fixtureFee);
            Apartment apartment = apartmentRepository.findById(dtoFixtureFeeShareIU.getDtoApartmentId())
                    .orElseThrow(() -> new RuntimeException("Apartment Not Found"));
            fixtureFeeShare.setApartment(apartment);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        FixtureFeeShare dbFixtureFeeShare = fixtureFeeShareRepository.save(fixtureFeeShare);

        BeanUtils.copyProperties(dbFixtureFeeShare, response);

        // dtoFixtureFee
        DtoFixtureFee dtoFixtureFee = new DtoFixtureFee();
        BeanUtils.copyProperties(dbFixtureFeeShare.getFixtureFee(), dtoFixtureFee);

        // dtoFixture
        DtoFixture dtoFixture = new DtoFixture();
        Fixture fixture = dbFixtureFeeShare.getFixtureFee().getFixture();
        BeanUtils.copyProperties(fixture, dtoFixture);

        // dtoProperty
        DtoProperty dtoProperty = new DtoProperty();
        Property property = fixture.getProperty();
        BeanUtils.copyProperties(property, dtoProperty);

        dtoFixture.setDtoProperty(dtoProperty);

        // dtoApartment
        DtoApartment dtoApartment = new DtoApartment();
        BeanUtils.copyProperties(dbFixtureFeeShare.getApartment(), dtoApartment);

        response.setDtoFixtureFee(dtoFixtureFee);
        response.setDtoApartment(dtoApartment);
        response.getDtoFixtureFee().setDtoFixture(dtoFixture);

        return response;
    }

    @Override
    public List<DtoFixtureFeeShare> getAllFixtureFeeShares() {
        List<DtoFixtureFeeShare> dtoFixtureFeeShareList = new ArrayList<>();
        List<FixtureFeeShare> fixtureFeeShareList = fixtureFeeShareRepository.findAll();

        for (FixtureFeeShare fixtureFeeShare : fixtureFeeShareList) {
            DtoFixtureFeeShare dtoFixtureFeeShare = new DtoFixtureFeeShare();
            FixtureFee fixtureFee = fixtureFeeShare.getFixtureFee();

            // dtoFixtureFee
            DtoFixtureFee dtoFixtureFee = new DtoFixtureFee();
            BeanUtils.copyProperties(fixtureFee, dtoFixtureFee);

            // dtoFixture
            Fixture fixture = fixtureFee.getFixture();
            DtoFixture dtoFixture = new DtoFixture();
            BeanUtils.copyProperties(fixture, dtoFixture);

            // dtoProperty
            Property property = fixture.getProperty();
            DtoProperty dtoProperty = new DtoProperty();
            BeanUtils.copyProperties(property, dtoProperty);

            dtoFixture.setDtoProperty(dtoProperty);
            dtoFixtureFee.setDtoFixture(dtoFixture);

            // dtoApartment
            Apartment apartment = fixtureFeeShare.getApartment();
            DtoApartment dtoApartment = new DtoApartment();
            BeanUtils.copyProperties(apartment, dtoApartment);

            BeanUtils.copyProperties(fixtureFeeShare, dtoFixtureFeeShare);
            dtoFixtureFeeShare.setDtoFixtureFee(dtoFixtureFee);
            dtoFixtureFeeShare.setDtoApartment(dtoApartment);

            dtoFixtureFeeShareList.add(dtoFixtureFeeShare);
        }
        return dtoFixtureFeeShareList;
    }

    @Override
    public DtoFixtureFeeShare getFixtureFeeShareById(Long id) {
        DtoFixtureFeeShare dtoFixtureFeeShare = new DtoFixtureFeeShare();
        Optional<FixtureFeeShare> fixtureFeeShareOptional = fixtureFeeShareRepository.findById(id);

        if (fixtureFeeShareOptional.isPresent()) {
            FixtureFeeShare dbFixtureFeeShare =  fixtureFeeShareOptional.get();

            // dtoFixtureFee
            FixtureFee fixtureFee = dbFixtureFeeShare.getFixtureFee();
            DtoFixtureFee dtoFixtureFee = new DtoFixtureFee();
            if (fixtureFee != null) {
                BeanUtils.copyProperties(fixtureFee, dtoFixtureFee);
            }

            // dtoFixture
            Fixture fixture = fixtureFee.getFixture();
            DtoFixture dtoFixture = new DtoFixture();
            if (fixture != null) {
                BeanUtils.copyProperties(fixture, dtoFixture);
            }

            // dtoProperty
            Property property = fixture.getProperty();
            DtoProperty dtoProperty = new DtoProperty();
            if (property != null) {
                BeanUtils.copyProperties(property, dtoProperty);
            }

            // dtoApartment
            Apartment apartment = dbFixtureFeeShare.getApartment();
            DtoApartment dtoApartment = new DtoApartment();
            if (apartment != null) {
                BeanUtils.copyProperties(apartment, dtoApartment);
            }

            dtoFixture.setDtoProperty(dtoProperty);
            dtoFixtureFee.setDtoFixture(dtoFixture);

            BeanUtils.copyProperties(dbFixtureFeeShare, dtoFixtureFeeShare);
            dtoFixtureFeeShare.setDtoFixtureFee(dtoFixtureFee);
            dtoFixtureFeeShare.setDtoApartment(dtoApartment);
            return dtoFixtureFeeShare;
        }
        return null;
    }

    @Override
    public void deleteFixtureFeeShareById(Long id) {
        Optional<FixtureFeeShare> fixtureFeeShareOptional = fixtureFeeShareRepository.findById(id);
        fixtureFeeShareOptional.ifPresent(fixtureFeeShare -> fixtureFeeShareRepository.delete(fixtureFeeShare));
    }

    @Override
    public DtoFixtureFeeShare updateFixtureFeeShareById(Long id, DtoFixtureFeeShareIU dtoFixtureFeeShareIU) {
        Optional<FixtureFeeShare> fixtureFeeShareOptional = fixtureFeeShareRepository.findById(id);

        if (fixtureFeeShareOptional.isPresent()) {
           FixtureFeeShare dbFixtureFeeShare = fixtureFeeShareOptional.get();

           dbFixtureFeeShare.setAmount(dtoFixtureFeeShareIU.getAmount());

           // fixtureFee
           Optional<FixtureFee> fixtureFeeOptional = fixtureFeeRepository.findById(dbFixtureFeeShare.getFixtureFee().getId());
           if (fixtureFeeOptional.isPresent()) {
               dbFixtureFeeShare.setFixtureFee(fixtureFeeOptional.get());
           }

           // dtoFixtureFee
           DtoFixtureFee dtoFixtureFee = new DtoFixtureFee();
           BeanUtils.copyProperties(dbFixtureFeeShare.getFixtureFee(), dtoFixtureFee);

           // dtoFixture
           DtoFixture dtoFixture = new DtoFixture();
           Fixture fixture = dbFixtureFeeShare.getFixtureFee().getFixture();
           BeanUtils.copyProperties(fixture, dtoFixture);

           // dtoProperty
           Property property = fixture.getProperty();
           DtoProperty dtoProperty = new DtoProperty();
           BeanUtils.copyProperties(property, dtoProperty);

           dtoFixture.setDtoProperty(dtoProperty);
           dtoFixtureFee.setDtoFixture(dtoFixture);

           // dtoApartment
           Optional<Apartment> apartmentOptional = apartmentRepository.findById(dbFixtureFeeShare.getApartment().getId());
           if (apartmentOptional.isPresent()) {
               dbFixtureFeeShare.setApartment(apartmentOptional.get());
           }

           DtoApartment dtoApartment = new DtoApartment();
           BeanUtils.copyProperties(dbFixtureFeeShare.getApartment(), dtoApartment);

           FixtureFeeShare updatedFixtureFeeShare = fixtureFeeShareRepository.save(dbFixtureFeeShare);

           DtoFixtureFeeShare dtoFixtureFeeShare = new DtoFixtureFeeShare();
           BeanUtils.copyProperties(updatedFixtureFeeShare, dtoFixtureFeeShare);

           dtoFixtureFeeShare.setDtoFixtureFee(dtoFixtureFee);
           dtoFixtureFeeShare.setDtoApartment(dtoApartment);

           return dtoFixtureFeeShare;
        }
        return null;
    }
} 