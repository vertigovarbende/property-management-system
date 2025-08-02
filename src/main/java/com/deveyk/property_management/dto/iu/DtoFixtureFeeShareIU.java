package com.deveyk.property_management.dto.iu;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFixtureFeeShareIU {

    private Double amount;
    private Long dtoFixtureFeeId;
    private Long dtoApartmentId;

}
