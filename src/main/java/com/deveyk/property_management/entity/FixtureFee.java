package com.deveyk.property_management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.*;

import java.time.LocalDate;

@Entity
@Table(name = "fixture_fee")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class FixtureFee {

    /*
    It keeps track of the total expenditure for a fixed asset.
    It is used for recording and reporting expenditures made on fixed assets.
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_amount")
    private Double totalAmount;  // The total amount of the fixture

    @DateTimeFormat(iso = ISO.DATE)
    // @JsonFormat(pattern="YYYY-MM-DD")
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fixture_id")
    private Fixture fixture;    // which fixture?
}