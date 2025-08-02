package com.deveyk.property_management.controller;

import com.deveyk.property_management.dto.DtoFixture;
import com.deveyk.property_management.dto.iu.DtoFixtureIU;
import com.deveyk.property_management.entity.Fixture;
import java.util.List;

public interface IFixtureController {

    public DtoFixture saveFixture(DtoFixtureIU dtoFixtureIU);

    public List<DtoFixture> getAllFixtures();

    public DtoFixture getFixtureById(Long id);

    public void deleteFixtureById(Long id);

    public DtoFixture updateFixtureById(Long id, DtoFixtureIU dtoFixtureIU);
} 