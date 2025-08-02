package com.deveyk.property_management.controller;

import com.deveyk.property_management.dto.DtoFixtureFeeShare;
import com.deveyk.property_management.dto.iu.DtoFixtureFeeShareIU;
import com.deveyk.property_management.entity.FixtureFeeShare;
import java.util.List;

public interface IFixtureFeeShareController {

    public DtoFixtureFeeShare saveFixtureFeeShare(DtoFixtureFeeShareIU dtoFixtureFeeShareIU);

    public List<DtoFixtureFeeShare> getAllFixtureFeeShares();

    public DtoFixtureFeeShare getFixtureFeeShareById(Long id);

    public void deleteFixtureFeeShareById(Long id);

    public DtoFixtureFeeShare updateFixtureFeeShareById(Long id, DtoFixtureFeeShareIU dtoFixtureFeeShareIU);
} 