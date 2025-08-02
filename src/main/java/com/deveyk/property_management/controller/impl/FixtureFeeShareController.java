package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IFixtureFeeShareController;
import com.deveyk.property_management.dto.DtoFixtureFeeShare;
import com.deveyk.property_management.dto.iu.DtoFixtureFeeShareIU;
import com.deveyk.property_management.entity.FixtureFeeShare;
import com.deveyk.property_management.service.IFixtureFeeShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/fixturefeeshare")
public class FixtureFeeShareController implements IFixtureFeeShareController {

    @Autowired
    private IFixtureFeeShareService fixtureFeeShareService;

    @PostMapping("/save")
    @Override
    public DtoFixtureFeeShare saveFixtureFeeShare(@RequestBody DtoFixtureFeeShareIU dtoFixtureFeeShareIU) {
        return fixtureFeeShareService.saveFixtureFeeShare(dtoFixtureFeeShareIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoFixtureFeeShare> getAllFixtureFeeShares() {
        return fixtureFeeShareService.getAllFixtureFeeShares();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoFixtureFeeShare getFixtureFeeShareById(@PathVariable(name = "id") Long id) {
        return fixtureFeeShareService.getFixtureFeeShareById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteFixtureFeeShareById(@PathVariable(name = "id") Long id) {
        fixtureFeeShareService.deleteFixtureFeeShareById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoFixtureFeeShare updateFixtureFeeShareById(@PathVariable(name = "id") Long id,
                                                     @RequestBody DtoFixtureFeeShareIU dtoFixtureFeeShareIU) {
        return fixtureFeeShareService.updateFixtureFeeShareById(id, dtoFixtureFeeShareIU);
    }
} 