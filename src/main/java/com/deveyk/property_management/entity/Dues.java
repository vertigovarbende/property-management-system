package com.deveyk.property_management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.*;

import java.time.LocalDate;

@Entity
@Table(name = "dues")
@Data // @Getter + @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dues {

    /*
    Keeps track of apartment maintenance fees and payment status.
    Used to track apartment maintenance fees and payments.
     */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount; // the amount of the due

    @DateTimeFormat(iso = ISO.DATE)
    // @JsonFormat(pattern="YYYY-MM-DD")
    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "paid")
    private Boolean paid;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment; // which apartment
}
