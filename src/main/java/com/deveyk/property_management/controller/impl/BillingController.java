package com.deveyk.property_management.controller.impl;

import com.deveyk.property_management.controller.IBillingController;
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
    public Billing saveBilling(@RequestBody Billing billing) {
        return billingService.saveBilling(billing);
    }

    @GetMapping("/list")
    @Override
    public List<Billing> getAllBillings() {
        return billingService.getAllBillings();
    }

    @GetMapping("/list/{id}")
    @Override
    public Billing getBillingById(@PathVariable(name = "id") Long id) {
        return billingService.getBillingById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteBillingById(@PathVariable(name = "id") Long id) {
        billingService.deleteBillingById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public Billing updateBillingById(@PathVariable(name = "id") Long id,
                                         @RequestBody Billing updateBilling) {
        return billingService.updateBillingById(id, updateBilling);
    }
}