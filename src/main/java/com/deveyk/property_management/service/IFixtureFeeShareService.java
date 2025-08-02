package com.deveyk.property_management.service;

import com.deveyk.property_management.dto.DtoFixture;
import com.deveyk.property_management.dto.DtoFixtureFeeShare;
import com.deveyk.property_management.dto.iu.DtoFixtureFeeShareIU;
import com.deveyk.property_management.entity.FixtureFeeShare;
import java.util.List;

public interface IFixtureFeeShareService {

    public DtoFixtureFeeShare saveFixtureFeeShare(DtoFixtureFeeShareIU dtoFixtureFeeShareIU);

    public List<DtoFixtureFeeShare> getAllFixtureFeeShares();

    public DtoFixtureFeeShare getFixtureFeeShareById(Long id);

    public void deleteFixtureFeeShareById(Long id);

    public DtoFixtureFeeShare updateFixtureFeeShareById(Long id, DtoFixtureFeeShareIU dtoFixtureFeeShareIU);
} 