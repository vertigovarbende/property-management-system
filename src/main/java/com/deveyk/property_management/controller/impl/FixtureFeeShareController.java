package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IFixtureFeeShareController;
import com.deveyk.property_management.entity.FixtureFeeShare;
import com.deveyk.property_management.service.IFixtureFeeShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/fixturefeeshare")
public class FixtureFeeShareController implements IFixtureFeeShareController {

    @Autowired
    private IFixtureFeeShareService fixtureFeeShareService;

    @PostMapping("/save")
    @Override
    public FixtureFeeShare saveFixtureFeeShare(@RequestBody FixtureFeeShare fixtureFeeShare) {
        return fixtureFeeShareService.saveFixtureFeeShare(fixtureFeeShare);
    }

    @GetMapping("/list")
    @Override
    public List<FixtureFeeShare> getAllFixtureFeeShares() {
        return fixtureFeeShareService.getAllFixtureFeeShares();
    }

    @GetMapping("/list/{id}")
    @Override
    public FixtureFeeShare getFixtureFeeShareById(@PathVariable(name = "id") Long id) {
        return fixtureFeeShareService.getFixtureFeeShareById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteFixtureFeeShareById(@PathVariable(name = "id") Long id) {
        fixtureFeeShareService.deleteFixtureFeeShareById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public FixtureFeeShare updateFixtureFeeShareById(@PathVariable(name = "id") Long id,
                                                     @RequestBody FixtureFeeShare updateFixtureFeeShare) {
        return fixtureFeeShareService.updateFixtureFeeShareById(id, updateFixtureFeeShare);
    }
} 