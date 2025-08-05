package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IExpenditureController;
import com.deveyk.property_management.dto.DtoExpenditure;
import com.deveyk.property_management.dto.iu.DtoExpenditureIU;
import com.deveyk.property_management.entity.Expenditure;
import com.deveyk.property_management.service.IExpenditureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/expenditure")
public class ExpenditureController implements IExpenditureController {

    @Autowired
    private IExpenditureService expenditureService;

    @PostMapping("/save")
    @Override
    public DtoExpenditure saveExpenditure(@RequestBody @Valid DtoExpenditureIU dtoExpenditureIU) {
        return expenditureService.saveExpenditure(dtoExpenditureIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoExpenditure> getAllExpenditures() {
        return expenditureService.getAllExpenditures();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoExpenditure getExpenditureById(@PathVariable(name = "id") Long id) {
        return expenditureService.getExpenditureById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteExpenditureById(@PathVariable(name = "id") Long id) {
        expenditureService.deleteExpenditureById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoExpenditure updateExpenditureById(@PathVariable(name = "id") Long id,
                                             @RequestBody @Valid DtoExpenditureIU dtoExpenditureIU) {
        return expenditureService.updateExpenditureById(id, dtoExpenditureIU);
    }
} 