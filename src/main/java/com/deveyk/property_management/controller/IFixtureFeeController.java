package com.deveyk.property_management.controller;

import com.deveyk.property_management.entity.FixtureFee;
import java.util.List;

public interface IFixtureFeeController {

    public FixtureFee saveFixtureFee(FixtureFee fixtureFee);

    public List<FixtureFee> getAllFixtureFees();

    public FixtureFee getFixtureFeeById(Long id);

    public void deleteFixtureFeeById(Long id);

    public FixtureFee updateFixtureFeeById(Long id, FixtureFee updateFixtureFee);
} 