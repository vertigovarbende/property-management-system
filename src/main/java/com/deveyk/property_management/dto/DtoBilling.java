package com.deveyk.property_management.dto;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoBilling {

    private Double totalAmount;
    private LocalDate billingDate;
    private Boolean paid;
    private DtoApartment apartment;

}
