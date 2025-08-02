package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IBillingController;
import com.deveyk.property_management.dto.DtoBilling;
import com.deveyk.property_management.dto.iu.DtoBillingIU;
import com.deveyk.property_management.entity.Billing;
import com.deveyk.property_management.service.IBillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/billings")
public class BillingController implements IBillingController {

    @Autowired
    private IBillingService billingService;

    @PostMapping("/save")
    @Override
    public DtoBilling saveBilling(@RequestBody DtoBillingIU dtoBillingIU) {
        return billingService.saveBilling(dtoBillingIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoBilling> getAllBillings() {
        return billingService.getAllBillings();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoBilling getBillingById(@PathVariable(name = "id") Long id) {
        return billingService.getBillingById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteBillingById(@PathVariable(name = "id") Long id) {
        billingService.deleteBillingById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoBilling updateBillingById(@PathVariable(name = "id") Long id,
                                         @RequestBody DtoBillingIU dtoBillingIU) {
        return billingService.updateBillingById(id, dtoBillingIU);
    }
}