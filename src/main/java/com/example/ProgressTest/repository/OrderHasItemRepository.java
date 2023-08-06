package com.example.ProgressTest.repository;


import com.example.ProgressTest.entity.Order_has_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHasItemRepository extends JpaRepository<Order_has_Item, Integer> {
}
