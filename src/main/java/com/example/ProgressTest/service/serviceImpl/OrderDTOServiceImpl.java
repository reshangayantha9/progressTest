package com.example.ProgressTest.service.serviceImpl;

import com.example.ProgressTest.entity.*;
import com.example.ProgressTest.repository.*;
import com.example.ProgressTest.service.OrderDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class OrderDTOServiceImpl implements OrderDTOService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderHasItemRepository orderHasItemRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public String placeOrder(OrderDTO orderDTO) {
        Order savedOrder;
        Order order=orderDTO.getOrder();
        Customer customer= customerRepository.findById(String.valueOf(orderDTO.getOrder().getCustomer().getId())).get();
        LocalDate date = LocalDate.now();
        Payment payment=orderDTO.getPayment();
        List<Order_has_Item> orderHasItem=orderDTO.getOrderHasItem();
        if(Objects.nonNull(customer)){
            order.setOrderDate(date);
            order.setCustomer(customer);
            savedOrder=orderRepository.save(order);
            if(Objects.nonNull(savedOrder)) {
                payment.setDate(date);
                payment.setOrder(savedOrder);
                paymentRepository.save(payment);
                for (Order_has_Item orders : orderHasItem) {
                    Item item = itemRepository.findById(orders.getItem().getCode()).get();
                    orders.setOrder(savedOrder);
                    orders.setItem(item);
                    orderHasItemRepository.save(orders);
                }
            }
        }
        return "your order placed successfully";
    }
}
