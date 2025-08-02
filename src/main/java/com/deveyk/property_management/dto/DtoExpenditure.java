package com.deveyk.property_management.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoExpenditure {

    private String type;
    private Double amount;
    private LocalDate date;
    private DtoProperty dtoProperty;

}
