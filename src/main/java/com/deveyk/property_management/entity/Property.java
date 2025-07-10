package com.deveyk.property_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "property")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "property_name")
    private String name; // sites or property name

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "property")
    private List<Apartment> apartments;
}