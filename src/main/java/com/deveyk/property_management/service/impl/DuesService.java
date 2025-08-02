package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.DtoDues;
import com.deveyk.property_management.dto.iu.DtoDuesIU;
import com.deveyk.property_management.entity.Apartment;
import com.deveyk.property_management.entity.Dues;
import com.deveyk.property_management.repository.ApartmentRepository;
import com.deveyk.property_management.repository.DuesRepository;
import com.deveyk.property_management.service.IDuesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DuesService implements IDuesService {

    @Autowired
    private DuesRepository duesRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public DtoDues saveDues(DtoDuesIU dtoDuesIU) {
        DtoDues response = new DtoDues();
        Dues dues = new Dues();

        try {
            BeanUtils.copyProperties(dtoDuesIU, dues);

            Apartment apartment = apartmentRepository.findById(dtoDuesIU.getDtoApartmentId())
                    .orElseThrow(() -> new RuntimeException("Apartment Not Found"));
            dues.setApartment(apartment);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        Dues dbDues = duesRepository.save(dues);

        BeanUtils.copyProperties(dbDues, response);

        DtoApartment dtoApartment = new DtoApartment();
        BeanUtils.copyProperties(dbDues.getApartment(), dtoApartment);
        response.setApartment(dtoApartment);

        return response;
    }

    @Override
    public List<DtoDues> getAllDues() {
        List<DtoDues> dtoDuesList = new ArrayList<>();
        List<Dues> duesList = duesRepository.findAll();

        for (Dues dues : duesList) {
            DtoDues dtoDues = new DtoDues();
            Apartment apartment = dues.getApartment();

            DtoApartment dtoApartment = new DtoApartment();
            BeanUtils.copyProperties(apartment, dtoApartment);

            BeanUtils.copyProperties(dues, dtoDues);
            dtoDues.setApartment(dtoApartment);

            dtoDuesList.add(dtoDues);
        }
        return dtoDuesList;
    }

    @Override
    public DtoDues getDuesById(Long id) {
        DtoDues dtoDues = new DtoDues();
        Optional<Dues> duesOptional = duesRepository.findById(id);

        if  (duesOptional.isPresent()) {
            Dues dbDues = duesOptional.get();

            Apartment apartment = dbDues.getApartment();
            DtoApartment dtoApartment = new DtoApartment();
            if (apartment != null) {
                BeanUtils.copyProperties(apartment, dtoApartment);
            }

            BeanUtils.copyProperties(dbDues, dtoDues);
            dtoDues.setApartment(dtoApartment);
            return dtoDues;
        }
        return null;
    }

    @Override
    public void deleteDuesById(Long id) {
       Optional<Dues> duesOptional = duesRepository.findById(id);
       duesOptional.ifPresent(dues -> duesRepository.delete(dues));
    }

    @Override
    public DtoDues updateDuesById(Long id, DtoDuesIU dtoDuesIU) {
        Optional<Dues> duesOptional = duesRepository.findById(id);

        if (duesOptional.isPresent()) {
            Dues dbDues = duesOptional.get();

            dbDues.setAmount(dtoDuesIU.getAmount());
            dbDues.setDueDate(dtoDuesIU.getDueDate());
            dbDues.setPaid(dtoDuesIU.getPaid());

            Optional<Apartment> apartmentOptional = apartmentRepository.findById(dtoDuesIU.getDtoApartmentId());
            if (apartmentOptional.isPresent()) {
                dbDues.setApartment(apartmentOptional.get());
            }

            Dues updatedDues = duesRepository.save(dbDues);

            DtoDues dtoDues = new DtoDues();
            BeanUtils.copyProperties(updatedDues, dtoDues);
            return dtoDues;
        }

        return null;
    }
} 