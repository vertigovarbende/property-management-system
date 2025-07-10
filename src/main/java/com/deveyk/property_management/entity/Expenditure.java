package com.deveyk.property_management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.*;

import java.time.LocalDate;

@Entity
@Table(name = "expenditure")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expenditure {

    /*
    Records expenses related to the site (e.g. electricity, water, cleaning, lift maintenance).
    Used to record and report all expenses incurred by site management.
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type; // Electricity, water, cleaning, lift maintenance, or other

    @Column(name = "amount")
    private Double amount; // the total amount of the expenditure

    // @JsonFormat(pattern="YYYY-MM-DD")
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description", length = 50)
    private String description; // the description of the expenditure

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property; // which property
}