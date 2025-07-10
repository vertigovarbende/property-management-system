package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.Expenditure;
import com.deveyk.property_management.repository.ExpenditureRepository;
import com.deveyk.property_management.service.IExpenditureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenditureService implements IExpenditureService {

    @Autowired
    private ExpenditureRepository expenditureRepository;

    @Override
    public Expenditure saveExpenditure(Expenditure expenditure) {
        return expenditureRepository.save(expenditure);
    }

    @Override
    public List<Expenditure> getAllExpenditures() {
        return expenditureRepository.findAll();
    }

    @Override
    public Expenditure getExpenditureById(Long id) {
        Optional<Expenditure> expenditureOptional = expenditureRepository.findById(id);
        return expenditureOptional.orElse(null);
    }

    @Override
    public void deleteExpenditureById(Long id) {
        Expenditure dbExpenditure = getExpenditureById(id);
        if (dbExpenditure != null)
            expenditureRepository.delete(dbExpenditure);
        else
            System.out.println("Expenditure not found");
    }

    @Override
    public Expenditure updateExpenditureById(Long id, Expenditure updateExpenditure) {
        Expenditure dbExpenditure = getExpenditureById(id);
        if (dbExpenditure != null) {
            dbExpenditure.setAmount(updateExpenditure.getAmount());
            dbExpenditure.setDescription(updateExpenditure.getDescription());
            dbExpenditure.setDate(updateExpenditure.getDate());
            return expenditureRepository.save(dbExpenditure);
        }
        return null;
    }
} 