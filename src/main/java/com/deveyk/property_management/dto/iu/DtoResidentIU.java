package com.deveyk.property_management.dto.iu;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoResidentIU {

    @NotEmpty(message = "Name is Empty!")
    @Size(min = 10, max = 50, message = "min 10 char, max 50 char")
    private String name;

    @NotEmpty(message = "Type is Empty!")
    @Size(min = 10, max = 50, message = "min 10 char, max 50 char")
    private String type;

    private String phone;

    @Email(message = "Change the email format!")
    private String email;

    private Long dtoApartmentId;

}
