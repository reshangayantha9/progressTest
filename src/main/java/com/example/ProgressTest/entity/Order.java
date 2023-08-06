package com.example.ProgressTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;
    private LocalDate orderDate;
    private double cost;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<Order_has_Item> orderHasItems;
    @JsonIgnore
    @OneToOne(mappedBy = "order")
    private Payment payment;

}
