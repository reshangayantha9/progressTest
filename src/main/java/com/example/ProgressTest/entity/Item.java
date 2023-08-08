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
    @Column(name="code")
    private int code;
    @Column(name="description",length = 45)
    private String description;
    @Column(name="qty")
    private int qty;
    @Column(name="unit_price")
    private double unitPrice;
    @Lob
    @Column(name="barcode")
    private byte[] barcode;
    @JsonIgnore
    @OneToMany(mappedBy = "item")
    private List<OrderHasItem> orderHasItems;
}
