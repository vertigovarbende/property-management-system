package com.deveyk.property_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fixture_fee_share")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FixtureFeeShare {

    /*
    It keeps track of the amounts allocated to each apartment for capital expenditures.
    It is used to fairly allocate and track capital expenditures among apartments.
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount; // share falling to the apartment

    @ManyToOne
    @JoinColumn(name = "fixture_fee_id")
    private FixtureFee fixtureFee;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment; // which apartment?
}
