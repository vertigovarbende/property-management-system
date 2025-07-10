package com.deveyk.property_management.controller;

import com.deveyk.property_management.entity.FixtureFeeShare;
import java.util.List;

public interface IFixtureFeeShareController {

    public FixtureFeeShare saveFixtureFeeShare(FixtureFeeShare fixtureFeeShare);

    public List<FixtureFeeShare> getAllFixtureFeeShares();

    public FixtureFeeShare getFixtureFeeShareById(Long id);

    public void deleteFixtureFeeShareById(Long id);

    public FixtureFeeShare updateFixtureFeeShareById(Long id, FixtureFeeShare updateFixtureFeeShare);
} 