package com.example.ProgressTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    private int id;
    private double payment;
    private String paymentType;
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "order_order_id", referencedColumnName = "orderId")
    private Order order;
}
