package com.deveyk.property_management.service;

import com.deveyk.property_management.entity.Billing;

import java.util.List;

public interface IBillingService {

    public Billing saveBilling(Billing billing);

    public List<Billing> getAllBillings();

    public Billing getBillingById(Long id);

    public void deleteBillingById(Long id);

    public Billing updateBillingById(Long id, Billing updateBilling);
}
