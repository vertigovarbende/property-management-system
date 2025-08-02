package com.deveyk.property_management.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixture {

    private String fixtureName;
    private String description;
    private DtoProperty dtoProperty;
}
