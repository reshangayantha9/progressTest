package com.example.ProgressTest.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name="id",length = 80)
    @GenericGenerator(name="customer_Id",strategy = "com.example.ProgressTest.entity.idGenerator.CustomerId")
    @GeneratedValue(generator="customer_Id")
    private String id;
    @Column(name="name",length = 45)
    private String name;
    @Column(name="address",length = 45)
    private String address;
    @Column(name="salary")
    private double salary;
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orderEntities;
}
