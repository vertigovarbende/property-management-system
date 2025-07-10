package com.deveyk.property_management.controller;

import com.deveyk.property_management.entity.Expenditure;
import java.util.List;

public interface IExpenditureController {

    public Expenditure saveExpenditure(Expenditure expenditure);

    public List<Expenditure> getAllExpenditures();

    public Expenditure getExpenditureById(Long id);

    public void deleteExpenditureById(Long id);

    public Expenditure updateExpenditureById(Long id, Expenditure updateExpenditure);
} 