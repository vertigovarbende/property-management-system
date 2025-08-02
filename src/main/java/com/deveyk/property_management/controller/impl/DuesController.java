package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IDuesController;
import com.deveyk.property_management.dto.DtoDues;
import com.deveyk.property_management.dto.iu.DtoDuesIU;
import com.deveyk.property_management.entity.Dues;
import com.deveyk.property_management.service.IDuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/dues")
public class DuesController implements IDuesController {

    @Autowired
    private IDuesService duesService;

    @PostMapping("/save")
    @Override
    public DtoDues saveDues(@RequestBody DtoDuesIU dtoDuesIU) {
        return duesService.saveDues(dtoDuesIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoDues> getAllDues() {
        return duesService.getAllDues();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoDues getDuesById(@PathVariable(name = "id") Long id) {
        return duesService.getDuesById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteDuesById(@PathVariable(name = "id") Long id) {
        duesService.deleteDuesById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoDues updateDuesById(@PathVariable(name = "id") Long id,
                               @RequestBody DtoDuesIU dtoDuesIU) {
        return duesService.updateDuesById(id, dtoDuesIU);
    }
} 