package com.deveyk.property_management.dto.iu;

import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoDuesIU {

    private Double amount;
    private LocalDate dueDate;
    private Boolean paid;
    private Long dtoApartmentId;

}
