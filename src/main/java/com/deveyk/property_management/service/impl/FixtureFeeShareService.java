package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.FixtureFeeShare;
import com.deveyk.property_management.repository.FixtureFeeShareRepository;
import com.deveyk.property_management.service.IFixtureFeeShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixtureFeeShareService implements IFixtureFeeShareService {

    @Autowired
    private FixtureFeeShareRepository fixtureFeeShareRepository;

    @Override
    public FixtureFeeShare saveFixtureFeeShare(FixtureFeeShare fixtureFeeShare) {
        return fixtureFeeShareRepository.save(fixtureFeeShare);
    }

    @Override
    public List<FixtureFeeShare> getAllFixtureFeeShares() {
        return fixtureFeeShareRepository.findAll();
    }

    @Override
    public FixtureFeeShare getFixtureFeeShareById(Long id) {
        Optional<FixtureFeeShare> fixtureFeeShareOptional = fixtureFeeShareRepository.findById(id);
        return fixtureFeeShareOptional.orElse(null);
    }

    @Override
    public void deleteFixtureFeeShareById(Long id) {
        FixtureFeeShare dbFixtureFeeShare = getFixtureFeeShareById(id);
        if (dbFixtureFeeShare != null)
            fixtureFeeShareRepository.delete(dbFixtureFeeShare);
        else
            System.out.println("FixtureFeeShare not found");
    }

    @Override
    public FixtureFeeShare updateFixtureFeeShareById(Long id, FixtureFeeShare updateFixtureFeeShare) {
        FixtureFeeShare dbFixtureFeeShare = getFixtureFeeShareById(id);
        if (dbFixtureFeeShare != null) {
            dbFixtureFeeShare.setAmount(updateFixtureFeeShare.getAmount());
            dbFixtureFeeShare.setFixtureFee(updateFixtureFeeShare.getFixtureFee());
            return fixtureFeeShareRepository.save(dbFixtureFeeShare);
        }
        return null;
    }
} 