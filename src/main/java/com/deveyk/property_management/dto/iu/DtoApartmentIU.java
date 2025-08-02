package com.deveyk.property_management.dto.iu;

import lombok.*;

@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoApartmentIU {

    private String number;
    private String type;
    private Double allotmentPercentage;
    private Long residentId;

}
