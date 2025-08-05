package com.deveyk.property_management.dto.iu;

import jakarta.validation.constraints.*;
import lombok.*;

@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoApartmentIU {

    @NotEmpty(message = "Number is Empty!")
    @Size(min = 2, max = 10)
    private String number;

    @NotEmpty(message = "Type is Empty!")
    @Size(min = 10, max = 50)
    private String type;

    private Double allotmentPercentage;

    private Long residentId;

}
