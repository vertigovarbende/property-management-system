package com.deveyk.property_management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.*;

import java.time.LocalDate;

@Entity
@Table(name = "billing")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    /*
    It keeps track of the total debt (maintenance fees(Dues.java) + capital expenditure)
    and payment status of an apartment.
    It is used for monthly or periodic debt and payment tracking on an apartment basis.
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_amount")
    private Double totalAmount; // dues + fixture

    @DateTimeFormat(iso = ISO.DATE)
    // @JsonFormat(pattern="YYYY-MM-DD")
    @Column(name = "billing_date")
    private LocalDate billingDate;

    @Column(name = "paid")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment; // which apartment?
}