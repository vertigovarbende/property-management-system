package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoExpenditure;
import com.deveyk.property_management.dto.DtoProperty;
import com.deveyk.property_management.dto.iu.DtoExpenditureIU;
import com.deveyk.property_management.entity.Expenditure;
import com.deveyk.property_management.entity.Property;
import com.deveyk.property_management.repository.ExpenditureRepository;
import com.deveyk.property_management.repository.PropertyRepository;
import com.deveyk.property_management.service.IExpenditureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenditureService implements IExpenditureService {

    @Autowired
    private ExpenditureRepository expenditureRepository;
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public DtoExpenditure saveExpenditure(DtoExpenditureIU dtoExpenditureIU) {
        DtoExpenditure response = new DtoExpenditure();
        Expenditure expenditure = new Expenditure();

        try {
            BeanUtils.copyProperties(dtoExpenditureIU, expenditure);
            Property property = propertyRepository.findById(dtoExpenditureIU.getDtoPropertyId())
                    .orElseThrow(() -> new RuntimeException("Property Not Found"));
            expenditure.setProperty(property);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        Expenditure dbExpenditure = expenditureRepository.save(expenditure);

        BeanUtils.copyProperties(dbExpenditure, response);

        DtoProperty dtoProperty = new DtoProperty();
        BeanUtils.copyProperties(dbExpenditure.getProperty(), dtoProperty);
        response.setDtoProperty(dtoProperty);

        return response;
    }

    @Override
    public List<DtoExpenditure> getAllExpenditures() {
        List<DtoExpenditure> dtoExpenditureList = new ArrayList<>();
        List<Expenditure> expenditureList = expenditureRepository.findAll();

        for (Expenditure expenditure : expenditureList) {
            DtoExpenditure dtoExpenditure = new DtoExpenditure();
            Property property = expenditure.getProperty();

            DtoProperty dtoProperty = new DtoProperty();
            BeanUtils.copyProperties(property, dtoProperty);

            BeanUtils.copyProperties(expenditure, dtoExpenditure);
            dtoExpenditure.setDtoProperty(dtoProperty);

            dtoExpenditureList.add(dtoExpenditure);
        }
        return dtoExpenditureList;
    }

    @Override
    public DtoExpenditure getExpenditureById(Long id) {
        DtoExpenditure dtoExpenditure =  new DtoExpenditure();
        Optional<Expenditure> expenditureOptional = expenditureRepository.findById(id);

        if (expenditureOptional.isPresent()) {
            Expenditure dbExpenditure = expenditureOptional.get();

            Property property = dbExpenditure.getProperty();
            DtoProperty dtoProperty = new DtoProperty();
            if (property != null) {
                BeanUtils.copyProperties(property, dtoProperty);
            }

            BeanUtils.copyProperties(dbExpenditure, dtoExpenditure);
            dtoExpenditure.setDtoProperty(dtoProperty);
            return dtoExpenditure;
        }
        return null;
    }

    @Override
    public void deleteExpenditureById(Long id) {
        Optional<Expenditure> expenditureOptional = expenditureRepository.findById(id);
        expenditureOptional.ifPresent(expenditure -> expenditureRepository.delete(expenditure));
    }

    @Override
    public DtoExpenditure updateExpenditureById(Long id, DtoExpenditureIU dtoExpenditureIU) {
        Optional<Expenditure> expenditureOptional = expenditureRepository.findById(id);

        if (expenditureOptional.isPresent()) {
            Expenditure dbExpenditure = expenditureOptional.get();

            dbExpenditure.setType(dtoExpenditureIU.getType());
            dbExpenditure.setAmount(dtoExpenditureIU.getAmount());
            dbExpenditure.setDate(dtoExpenditureIU.getDate());
            dbExpenditure.setDescription(dtoExpenditureIU.getDescription());

            Optional<Property> propertyOptional =  propertyRepository.findById(dtoExpenditureIU.getDtoPropertyId());
            if (propertyOptional.isPresent()) {
                dbExpenditure.setProperty(propertyOptional.get());
            }

            DtoProperty dtoProperty = new DtoProperty();
            BeanUtils.copyProperties(dbExpenditure.getProperty(), dtoProperty);

            Expenditure updatedExpenditure = expenditureRepository.save(dbExpenditure);

            DtoExpenditure dtoExpenditure = new DtoExpenditure();
            BeanUtils.copyProperties(updatedExpenditure, dtoExpenditure);
            dtoExpenditure.setDtoProperty(dtoProperty);
            return dtoExpenditure;
        }
        return null;
    }
} 