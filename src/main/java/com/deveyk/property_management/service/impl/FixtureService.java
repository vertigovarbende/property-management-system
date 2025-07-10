package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.Fixture;
import com.deveyk.property_management.repository.FixtureRepository;
import com.deveyk.property_management.service.IFixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixtureService implements IFixtureService {

    @Autowired
    private FixtureRepository fixtureRepository;

    @Override
    public Fixture saveFixture(Fixture fixture) {
        return fixtureRepository.save(fixture);
    }

    @Override
    public List<Fixture> getAllFixtures() {
        return fixtureRepository.findAll();
    }

    @Override
    public Fixture getFixtureById(Long id) {
        Optional<Fixture> fixtureOptional = fixtureRepository.findById(id);
        return fixtureOptional.orElse(null);
    }

    @Override
    public void deleteFixtureById(Long id) {
        Fixture dbFixture = getFixtureById(id);
        if (dbFixture != null)
            fixtureRepository.delete(dbFixture);
        else
            System.out.println("Fixture not found");
    }

    @Override
    public Fixture updateFixtureById(Long id, Fixture updateFixture) {
        Fixture dbFixture = getFixtureById(id);
        if (dbFixture != null) {
            dbFixture.setFixtureName(updateFixture.getFixtureName());
            dbFixture.setDescription(updateFixture.getDescription());
            return fixtureRepository.save(dbFixture);
        }
        return null;
    }
} 