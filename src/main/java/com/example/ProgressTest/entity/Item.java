package com.example.ProgressTest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    private int code;
    private String description;
    private int qty;
    private double unitPrice;
    @Lob
    private byte[] barcode;
    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<Order_has_Item> orderHasItems;
}
