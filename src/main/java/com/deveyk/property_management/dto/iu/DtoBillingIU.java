package com.deveyk.property_management.dto.iu;

import com.deveyk.property_management.dto.DtoApartment;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBillingIU {

    private Double totalAmount;
    private LocalDate billingDate;
    private Boolean paid;
    private Long dtoApartmentId;

}
