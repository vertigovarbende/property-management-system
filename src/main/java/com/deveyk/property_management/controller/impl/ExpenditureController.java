package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IExpenditureController;
import com.deveyk.property_management.entity.Expenditure;
import com.deveyk.property_management.service.IExpenditureService;
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
    public Expenditure saveExpenditure(@RequestBody Expenditure expenditure) {
        return expenditureService.saveExpenditure(expenditure);
    }

    @GetMapping("/list")
    @Override
    public List<Expenditure> getAllExpenditures() {
        return expenditureService.getAllExpenditures();
    }

    @GetMapping("/list/{id}")
    @Override
    public Expenditure getExpenditureById(@PathVariable(name = "id") Long id) {
        return expenditureService.getExpenditureById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteExpenditureById(@PathVariable(name = "id") Long id) {
        expenditureService.deleteExpenditureById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Expenditure updateExpenditureById(@PathVariable(name = "id") Long id,
                                             @RequestBody Expenditure updateExpenditure) {
        return expenditureService.updateExpenditureById(id, updateExpenditure);
    }
} 