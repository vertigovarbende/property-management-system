package com.deveyk.property_management.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoDues {

    private Double amount;
    private LocalDate dueDate;
    private Boolean paid;
    private DtoApartment apartment;

}
