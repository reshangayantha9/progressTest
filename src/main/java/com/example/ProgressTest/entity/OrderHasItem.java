package com.example.ProgressTest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_has_item")
@IdClass(com.example.ProgressTest.entity.idGenerator.OrderHasItemPK.class)
public class OrderHasItem implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_order_id", referencedColumnName = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "code")
    private Item item;
    private double price;
    private double qty;


}
