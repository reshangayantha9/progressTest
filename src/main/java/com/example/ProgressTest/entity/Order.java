package com.example.ProgressTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name="order_id",length = 80)
    @GenericGenerator(name="order_Id",strategy = "com.example.ProgressTest.entity.idGenerator.OrderId")
    @GeneratedValue(generator="order_Id")
    private String orderId;
    @Column(name="order_date")
    private LocalDate orderDate;
    @Column(name="cost")
    private double cost;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<OrderHasItem> orderHasItems;
    @JsonIgnore
    @OneToOne(mappedBy = "order")
    private Payment payment;


}
