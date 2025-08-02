package com.deveyk.property_management.dto.iu;

import com.deveyk.property_management.dto.DtoFixture;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixtureFeeIU {

    private Double totalAmount;
    private LocalDate date;
    private String description;
    private Long dtoFixtureId;

}
