package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IDuesController;
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
    public Dues saveDues(@RequestBody Dues dues) {
        return duesService.saveDues(dues);
    }

    @GetMapping("/list")
    @Override
    public List<Dues> getAllDues() {
        return duesService.getAllDues();
    }

    @GetMapping("/list/{id}")
    @Override
    public Dues getDuesById(@PathVariable(name = "id") Long id) {
        return duesService.getDuesById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteDuesById(@PathVariable(name = "id") Long id) {
        duesService.deleteDuesById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Dues updateDuesById(@PathVariable(name = "id") Long id,
                               @RequestBody Dues updateDues) {
        return duesService.updateDuesById(id, updateDues);
    }
} 