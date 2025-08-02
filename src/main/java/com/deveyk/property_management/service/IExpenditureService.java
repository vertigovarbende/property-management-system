package com.deveyk.property_management.service;

import com.deveyk.property_management.dto.DtoExpenditure;
import com.deveyk.property_management.dto.iu.DtoExpenditureIU;
import com.deveyk.property_management.entity.Expenditure;
import java.util.List;

public interface IExpenditureService {

    public DtoExpenditure saveExpenditure(DtoExpenditureIU dtoExpenditureIU);

    public List<DtoExpenditure> getAllExpenditures();

    public DtoExpenditure getExpenditureById(Long id);

    public void deleteExpenditureById(Long id);

    public DtoExpenditure updateExpenditureById(Long id, DtoExpenditureIU dtoExpenditureIU);
} 