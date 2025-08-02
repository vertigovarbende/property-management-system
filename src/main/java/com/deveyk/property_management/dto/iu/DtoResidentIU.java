package com.deveyk.property_management.dto.iu;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoResidentIU {

    private String name;
    private String type;
    private String phone;
    private String email;
    private Long dtoApartmentId;

}
