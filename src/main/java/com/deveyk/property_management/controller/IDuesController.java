package com.deveyk.property_management.controller;

import com.deveyk.property_management.entity.Dues;
import java.util.List;

public interface IDuesController {

    public Dues saveDues(Dues dues);

    public List<Dues> getAllDues();

    public Dues getDuesById(Long id);

    public void deleteDuesById(Long id);

    public Dues updateDuesById(Long id, Dues updateDues);
} 