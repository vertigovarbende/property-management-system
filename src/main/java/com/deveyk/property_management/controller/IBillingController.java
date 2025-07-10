package com.deveyk.property_management.controller;

import com.deveyk.property_management.entity.Billing;

import java.util.List;

public interface IBillingController {

    public Billing saveBilling(Billing apartment);

    public List<Billing> getAllBillings();

    public Billing getBillingById(Long id);

    public void deleteBillingById(Long id);

    public Billing updateBillingById(Long id, Billing updateBilling);
}
