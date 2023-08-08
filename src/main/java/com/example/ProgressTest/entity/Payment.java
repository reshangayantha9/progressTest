package com.example.ProgressTest.entity;

import com.example.ProgressTest.enums.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="payment")
    private double payment;
    @Column(name="payment_type")
    private PaymentType paymentType;
    @Column(name="date")
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "order_order_id", referencedColumnName = "order_id")
    private Order order;
}
