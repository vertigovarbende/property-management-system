package com.deveyk.property_management.dto.iu;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixtureFeeIU {

    private Double totalAmount;

    private LocalDate date;

    @NotEmpty(message = "Description is Empty!")
    @Size(min = 10, max = 50, message = "min 10 char, max 50 char")
    private String description;

    private Long dtoFixtureId;

}
