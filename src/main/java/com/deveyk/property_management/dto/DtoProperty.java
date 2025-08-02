package com.deveyk.property_management.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoProperty {

    private String name;
    private String address;
    private List<DtoApartment> apartmentList;

}
