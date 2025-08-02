package com.deveyk.property_management.service;

import com.deveyk.property_management.dto.DtoFixtureFee;
import com.deveyk.property_management.dto.iu.DtoFixtureFeeIU;
import com.deveyk.property_management.entity.FixtureFee;
import java.util.List;

public interface IFixtureFeeService {

    public DtoFixtureFee saveFixtureFee(DtoFixtureFeeIU dtoFixtureFeeIU);

    public List<DtoFixtureFee> getAllFixtureFees();

    public DtoFixtureFee getFixtureFeeById(Long id);

    public void deleteFixtureFeeById(Long id);

    public DtoFixtureFee updateFixtureFeeById(Long id, DtoFixtureFeeIU dtoFixtureFeeIU);
} 