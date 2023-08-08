package com.example.ProgressTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_has_item")

public class OrderHasItem {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "order_order_id", referencedColumnName = "order_id",unique = true,nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "code",unique = true,nullable = false)
    private Item item;
    private double price;
    private double qty;


}
