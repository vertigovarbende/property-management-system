package com.deveyk.property_management.controller;

import com.deveyk.property_management.dto.DtoBilling;
import com.deveyk.property_management.dto.iu.DtoBillingIU;
import com.deveyk.property_management.entity.Billing;

import java.util.List;

public interface IBillingController {

    public DtoBilling saveBilling(DtoBillingIU dtoBillingIU);

    public List<DtoBilling> getAllBillings();

    public DtoBilling getBillingById(Long id);

    public void deleteBillingById(Long id);

    public DtoBilling updateBillingById(Long id, DtoBillingIU dtoBillingIU);
}
