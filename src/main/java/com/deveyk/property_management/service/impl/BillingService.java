package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.entity.Apartment;
import com.deveyk.property_management.entity.Billing;
import com.deveyk.property_management.repository.BillingRepository;
import com.deveyk.property_management.service.IBillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService implements IBillingService {

    @Autowired
    private BillingRepository billingRepository;

    @Override
    public Billing saveBilling(Billing apartment) {
        return billingRepository.save(apartment);
    }

    @Override
    public List<Billing> getAllBillings() {
        List<Billing> billingList = billingRepository.findAll();
        return billingList;
    }

    @Override
    public Billing getBillingById(Long id) {
        Optional<Billing> billingOptional = billingRepository.findById(id);
        // or !billingOptional.isEmpty()
        if (billingOptional.isPresent()) {
            return billingOptional.get();
        }
        return null;
        // or we can do implementation functional way!
        // return billingOptional.orElse(null);
    }

    @Override
    public void deleteBillingById(Long id) {
        Billing dbBilling = getBillingById(id);
        if (dbBilling != null)
            billingRepository.delete(dbBilling);
        else
            System.out.println("Billing not found");
    }

    @Override
    public Billing updateBillingById(Long id, Billing updateBilling) {
        Billing dbBilling = getBillingById(id);
        if (dbBilling != null) {
            dbBilling.setBillingDate(updateBilling.getBillingDate());
            dbBilling.setPaid(updateBilling.getPaid());

            return billingRepository.save(dbBilling);
        }
        return null;
    }
}
