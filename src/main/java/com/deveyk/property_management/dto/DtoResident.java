package com.deveyk.property_management.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoResident {

    private String name;
    private String type;
    private DtoApartment apartment;

}
