package com.example.ProgressTest.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private double salary;
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
