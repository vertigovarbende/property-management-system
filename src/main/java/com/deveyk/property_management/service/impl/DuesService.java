package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.Dues;
import com.deveyk.property_management.repository.DuesRepository;
import com.deveyk.property_management.service.IDuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuesService implements IDuesService {

    @Autowired
    private DuesRepository duesRepository;

    @Override
    public Dues saveDues(Dues dues) {
        return duesRepository.save(dues);
    }

    @Override
    public List<Dues> getAllDues() {
        return duesRepository.findAll();
    }

    @Override
    public Dues getDuesById(Long id) {
        Optional<Dues> duesOptional = duesRepository.findById(id);
        return duesOptional.orElse(null);
    }

    @Override
    public void deleteDuesById(Long id) {
        Dues dbDues = getDuesById(id);
        if (dbDues != null)
            duesRepository.delete(dbDues);
        else
            System.out.println("Dues not found");
    }

    @Override
    public Dues updateDuesById(Long id, Dues updateDues) {
        Dues dbDues = getDuesById(id);
        if (dbDues != null) {
            dbDues.setAmount(updateDues.getAmount());
            dbDues.setDueDate(updateDues.getDueDate());
            dbDues.setPaid(updateDues.getPaid());
            return duesRepository.save(dbDues);
        }
        return null;
    }
} 