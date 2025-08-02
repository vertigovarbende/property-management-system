package com.deveyk.property_management.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixtureFee {

    private Double totalAmount;
    private LocalDate date;
    private String description;
    private DtoFixture dtoFixture;
}
