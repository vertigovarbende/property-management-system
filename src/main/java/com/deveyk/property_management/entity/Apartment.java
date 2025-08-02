package com.deveyk.property_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apartment")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {

    /*
    Represents an apartment.
    Information about the unit, such as which site it is located on and who lives there, is stored here.
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, length = 10)
    private String number; // the number of the apartment (d1, d2 etc.)

    @Column(name = "type", nullable = false, length = 20)
    private String type;   // studio, one bedroom or two bedroom (1+0, 1+1, 2+1 etc.)

    @Column(name = "allotment_percentage")
    private Double allotmentPercentage; // share of fixture costs

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property; // which property

    @OneToOne()
    @JoinColumn(name = "resident_id")
    private Resident resident; // which resident

}