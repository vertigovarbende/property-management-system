package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IFixtureFeeController;
import com.deveyk.property_management.dto.DtoFixtureFee;
import com.deveyk.property_management.dto.iu.DtoFixtureFeeIU;
import com.deveyk.property_management.entity.FixtureFee;
import com.deveyk.property_management.service.IFixtureFeeService;
import jakarta.validation.Valid;
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
    public DtoFixtureFee saveFixtureFee(@RequestBody @Valid DtoFixtureFeeIU dtoFixtureFeeIU) {
        return fixtureFeeService.saveFixtureFee(dtoFixtureFeeIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoFixtureFee> getAllFixtureFees() {
        return fixtureFeeService.getAllFixtureFees();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoFixtureFee getFixtureFeeById(@PathVariable(name = "id") Long id) {
        return fixtureFeeService.getFixtureFeeById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteFixtureFeeById(@PathVariable(name = "id") Long id) {
        fixtureFeeService.deleteFixtureFeeById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoFixtureFee updateFixtureFeeById(@PathVariable(name = "id") Long id,
                                           @RequestBody @Valid DtoFixtureFeeIU dtoFixtureFeeIU) {
        return fixtureFeeService.updateFixtureFeeById(id, dtoFixtureFeeIU);
    }
} 