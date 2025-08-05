package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IFixtureController;
import com.deveyk.property_management.dto.DtoFixture;
import com.deveyk.property_management.dto.iu.DtoFixtureIU;
import com.deveyk.property_management.entity.Fixture;
import com.deveyk.property_management.service.IFixtureService;
import jakarta.validation.Valid;
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
    public DtoFixture saveFixture(@RequestBody @Valid DtoFixtureIU dtoFixtureIU) {
        return fixtureService.saveFixture(dtoFixtureIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoFixture> getAllFixtures() {
        return fixtureService.getAllFixtures();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoFixture getFixtureById(@PathVariable(name = "id") Long id) {
        return fixtureService.getFixtureById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteFixtureById(@PathVariable(name = "id") Long id) {
        fixtureService.deleteFixtureById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoFixture updateFixtureById(@PathVariable(name = "id") Long id,
                                     @RequestBody @Valid DtoFixtureIU dtoFixtureIU) {
        return fixtureService.updateFixtureById(id, dtoFixtureIU);
    }
} 