package com.example.ProgressTest.controller;
import com.example.ProgressTest.entity.OrderDTO;
import com.example.ProgressTest.service.OrderDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/main/place-order")
public class OrderDTOController {
    @Autowired
    private OrderDTOService orderDTOService;

    @PostMapping
    public String placeOrder(@RequestBody OrderDTO orderDTO){
        return orderDTOService.placeOrder(orderDTO);
    }

}
