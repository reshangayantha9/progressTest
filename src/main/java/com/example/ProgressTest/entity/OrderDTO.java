package com.example.ProgressTest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Order order;
    private  Payment payment;
    private List<OrderHasItem> orderHasItem;

}
