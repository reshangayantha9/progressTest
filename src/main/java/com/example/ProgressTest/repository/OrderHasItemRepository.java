package com.example.ProgressTest.repository;
import com.example.ProgressTest.entity.OrderHasItem;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderHasItemRepository extends JpaRepository<OrderHasItem,Integer> {
}
