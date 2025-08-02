package com.deveyk.property_management.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixtureFeeShare {

    private Double amount;
    private DtoFixtureFee dtoFixtureFee;
    private DtoApartment dtoApartment;

}
