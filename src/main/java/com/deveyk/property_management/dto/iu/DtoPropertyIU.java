package com.deveyk.property_management.dto.iu;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoPropertyIU {

    @NotEmpty(message = "Name is Empty!")
    @Size(min = 10, max = 50, message = "min 10 char, max 50 char")
    private String name;

    @NotEmpty(message = "Address is Empty!")
    @Size(min = 10, max = 100, message = "min 10 char, max 100 char")
    private String address;

    private List<Long> dtoApartmentIds;

}
