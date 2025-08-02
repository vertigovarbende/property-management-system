package com.deveyk.property_management.service.impl;

import com.deveyk.property_management.dto.DtoApartment;
import com.deveyk.property_management.dto.DtoBilling;
import com.deveyk.property_management.dto.iu.DtoBillingIU;
import com.deveyk.property_management.entity.Apartment;
import com.deveyk.property_management.entity.Billing;
import com.deveyk.property_management.repository.ApartmentRepository;
import com.deveyk.property_management.repository.BillingRepository;
import com.deveyk.property_management.service.IBillingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService implements IBillingService {

    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public DtoBilling saveBilling(DtoBillingIU dtoBillingIU) {
        DtoBilling response = new DtoBilling();
        Billing billing = new Billing();

        try {
            BeanUtils.copyProperties(dtoBillingIU, billing);

            Apartment apartment = apartmentRepository.findById(dtoBillingIU.getDtoApartmentId())
                    .orElseThrow(() -> new RuntimeException("Apartment not found"));
            billing.setApartment(apartment);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        Billing dbBilling = billingRepository.save(billing);

        BeanUtils.copyProperties(dbBilling, response);

        DtoApartment dtoApartment = new DtoApartment();
        BeanUtils.copyProperties(dbBilling.getApartment(), dtoApartment);
        response.setApartment(dtoApartment);

        return response;
    }

    @Override
    public List<DtoBilling> getAllBillings() {
        List<DtoBilling> dtoBillingList = new ArrayList<>();
        List<Billing> billingList = billingRepository.findAll();

        for (Billing billing : billingList) {
            DtoBilling dtoBilling = new DtoBilling();
            Apartment apartment = billing.getApartment();

            DtoApartment dtoApartment = new DtoApartment();
            BeanUtils.copyProperties(apartment, dtoApartment);

            BeanUtils.copyProperties(billing, dtoBilling);
            dtoBilling.setApartment(dtoApartment);

            dtoBillingList.add(dtoBilling);
        }
        return dtoBillingList;
    }

    @Override
    public DtoBilling getBillingById(Long id) {
        DtoBilling dtoBilling = new DtoBilling();
        Optional<Billing> billingOptional = billingRepository.findById(id);

        if (billingOptional.isPresent()) {
            Billing dbBilling =  billingOptional.get();

            Apartment apartment = dbBilling.getApartment();

            DtoApartment dtoApartment = new DtoApartment();
            if (apartment != null) {
                BeanUtils.copyProperties(apartment, dtoApartment);
            }

            BeanUtils.copyProperties(dbBilling, dtoBilling);
            dtoBilling.setApartment(dtoApartment);

            return dtoBilling;
        }

        return null;
    }

    @Override
    public void deleteBillingById(Long id) {
        Optional<Billing> billingOptional = billingRepository.findById(id);
        billingOptional.ifPresent(billing -> billingRepository.delete(billing));
    }

    @Override
    public DtoBilling updateBillingById(Long id, DtoBillingIU dtoBillingIU) {
        Optional<Billing> billingOptional = billingRepository.findById(id);

        if (billingOptional.isPresent()) {
            Billing dbBilling = billingOptional.get();

            dbBilling.setTotalAmount(dtoBillingIU.getTotalAmount());
            dbBilling.setBillingDate(dtoBillingIU.getBillingDate());
            dbBilling.setPaid(dtoBillingIU.getPaid());

            Optional<Apartment> apartmentOptional = apartmentRepository.findById(dtoBillingIU.getDtoApartmentId());
            if (apartmentOptional.isPresent()) {
                dbBilling.setApartment(apartmentOptional.get());
            }

            Billing updatedBilling = billingRepository.save(dbBilling);

            DtoBilling dtoBilling = new DtoBilling();
            BeanUtils.copyProperties(updatedBilling, dtoBilling);
            return dtoBilling;
        }

        return null;
    }
}