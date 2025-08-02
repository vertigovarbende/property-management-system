package com.deveyk.property_management.dto.iu;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoPropertyIU {

    private String name;
    private String address;
    private List<Long> dtoApartmentIds;

}
