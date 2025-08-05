package com.deveyk.property_management.dto.iu;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixtureIU {

    @NotEmpty(message = "Fixture Name is Empty!")
    @Size(min = 10, max = 50, message = "min 10 char, max 50 char")
    private String fixtureName;

    @NotEmpty(message = "Description is Empty!")
    @Size(min = 10, max = 50, message = "min 10 char, max 50 char")
    private String description;

    private Long dtoPropertyId;

}
