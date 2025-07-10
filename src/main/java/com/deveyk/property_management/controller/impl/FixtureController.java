package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IFixtureController;
import com.deveyk.property_management.entity.Fixture;
import com.deveyk.property_management.service.IFixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/fixture")
public class FixtureController implements IFixtureController {

    @Autowired
    private IFixtureService fixtureService;

    @PostMapping("/save")
    @Override
    public Fixture saveFixture(@RequestBody Fixture fixture) {
        return fixtureService.saveFixture(fixture);
    }

    @GetMapping("/list")
    @Override
    public List<Fixture> getAllFixtures() {
        return fixtureService.getAllFixtures();
    }

    @GetMapping("/list/{id}")
    @Override
    public Fixture getFixtureById(@PathVariable(name = "id") Long id) {
        return fixtureService.getFixtureById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteFixtureById(@PathVariable(name = "id") Long id) {
        fixtureService.deleteFixtureById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Fixture updateFixtureById(@PathVariable(name = "id") Long id,
                                     @RequestBody Fixture updateFixture) {
        return fixtureService.updateFixtureById(id, updateFixture);
    }
} 