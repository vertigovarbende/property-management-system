package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IFixtureFeeController;
import com.deveyk.property_management.entity.FixtureFee;
import com.deveyk.property_management.service.IFixtureFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/fixturefee")
public class FixtureFeeController implements IFixtureFeeController {

    @Autowired
    private IFixtureFeeService fixtureFeeService;

    @PostMapping("/save")
    @Override
    public FixtureFee saveFixtureFee(@RequestBody FixtureFee fixtureFee) {
        return fixtureFeeService.saveFixtureFee(fixtureFee);
    }

    @GetMapping("/list")
    @Override
    public List<FixtureFee> getAllFixtureFees() {
        return fixtureFeeService.getAllFixtureFees();
    }

    @GetMapping("/list/{id}")
    @Override
    public FixtureFee getFixtureFeeById(@PathVariable(name = "id") Long id) {
        return fixtureFeeService.getFixtureFeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteFixtureFeeById(@PathVariable(name = "id") Long id) {
        fixtureFeeService.deleteFixtureFeeById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public FixtureFee updateFixtureFeeById(@PathVariable(name = "id") Long id,
                                           @RequestBody FixtureFee updateFixtureFee) {
        return fixtureFeeService.updateFixtureFeeById(id, updateFixtureFee);
    }
} 