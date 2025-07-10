package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.FixtureFee;
import com.deveyk.property_management.repository.FixtureFeeRepository;
import com.deveyk.property_management.service.IFixtureFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixtureFeeService implements IFixtureFeeService {

    @Autowired
    private FixtureFeeRepository fixtureFeeRepository;

    @Override
    public FixtureFee saveFixtureFee(FixtureFee fixtureFee) {
        return fixtureFeeRepository.save(fixtureFee);
    }

    @Override
    public List<FixtureFee> getAllFixtureFees() {
        return fixtureFeeRepository.findAll();
    }

    @Override
    public FixtureFee getFixtureFeeById(Long id) {
        Optional<FixtureFee> fixtureFeeOptional = fixtureFeeRepository.findById(id);
        return fixtureFeeOptional.orElse(null);
    }

    @Override
    public void deleteFixtureFeeById(Long id) {
        FixtureFee dbFixtureFee = getFixtureFeeById(id);
        if (dbFixtureFee != null)
            fixtureFeeRepository.delete(dbFixtureFee);
        else
            System.out.println("FixtureFee not found");
    }

    @Override
    public FixtureFee updateFixtureFeeById(Long id, FixtureFee updateFixtureFee) {
        FixtureFee dbFixtureFee = getFixtureFeeById(id);
        if (dbFixtureFee != null) {
            dbFixtureFee.setTotalAmount(updateFixtureFee.getTotalAmount());
            dbFixtureFee.setFixture(updateFixtureFee.getFixture());
            dbFixtureFee.setDate(updateFixtureFee.getDate());
            return fixtureFeeRepository.save(dbFixtureFee);
        }
        return null;
    }
} 