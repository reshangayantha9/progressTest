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

public class Order_has_Item {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "order_order_id", referencedColumnName = "orderId")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "code")
    private Item item;
    private double price;
    private double qty;


}
