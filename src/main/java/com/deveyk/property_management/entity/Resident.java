package com.deveyk.property_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resident")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resident {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resident_name")
    private String name;

    @Column(name = "type")
    private String type; // owner or tenant

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

}