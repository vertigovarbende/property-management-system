package com.deveyk.property_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "fixture")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fixture {

    /*
    Defines common fixtures belonging to the site (e.g. elevator, generator).
    Used to manage commonly used fixtures and track which apartments benefit from these fixtures.
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fixture_name", nullable = false)
    private String fixtureName; // name of the fixture (lift/elevator, generator etc.)

    @Column(name = "description", length = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property; // which property

    @ManyToMany
    @JoinTable(
            name = "fixture_apartment",
            joinColumns = @JoinColumn(name = "fixture_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id")
    )
    private List<Apartment> apartments; // which apartment used these fixtures?
}