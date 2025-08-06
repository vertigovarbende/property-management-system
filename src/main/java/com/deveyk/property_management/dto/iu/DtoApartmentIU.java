package com.deveyk.property_management.dto.iu;

import jakarta.validation.constraints.*;
import lombok.*;

@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoApartmentIU {

    @NotEmpty(message = "Number is Empty!")
    @Size(min = 2, max = 10, message = "min 2 char, max 10 char")
    private String number;

    @NotEmpty(message = "Type is Empty!")
    @Size(min = 2, max = 50, message = "min 2 char, max 50 char")
    private String type;

    private Double allotmentPercentage;

    private Long residentId;

}
