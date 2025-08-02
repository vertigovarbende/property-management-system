package com.deveyk.property_management.service;

import com.deveyk.property_management.dto.DtoDues;
import com.deveyk.property_management.dto.iu.DtoDuesIU;
import com.deveyk.property_management.entity.Dues;
import java.util.List;

public interface IDuesService {

    public DtoDues saveDues(DtoDuesIU dtoDuesIU);

    public List<DtoDues> getAllDues();

    public DtoDues getDuesById(Long id);

    public void deleteDuesById(Long id);

    public DtoDues updateDuesById(Long id, DtoDuesIU dtoDuesIU);
} 