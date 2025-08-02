package com.deveyk.property_management.dto.iu;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoExpenditureIU {

    private String type;
    private Double amount;
    private LocalDate date;
    private String description;
    private Long dtoPropertyId;

}
