package com.deveyk.property_management.dto.iu;

import com.deveyk.property_management.dto.DtoProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixtureIU {

    private String fixtureName;
    private String description;
    private Long dtoPropertyId;

}
