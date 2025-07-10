package com.deveyk.property_management.service;

import com.deveyk.property_management.entity.Fixture;
import java.util.List;

public interface IFixtureService {

    public Fixture saveFixture(Fixture fixture);

    public List<Fixture> getAllFixtures();

    public Fixture getFixtureById(Long id);

    public void deleteFixtureById(Long id);

    public Fixture updateFixtureById(Long id, Fixture updateFixture);
} 