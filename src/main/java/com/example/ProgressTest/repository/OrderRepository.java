package com.example.ProgressTest.repository;

import com.example.ProgressTest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    @Query(value = "SELECT o FROM Order o WHERE o.orderDate=:d ")
    List<Order> findDaily(@Param("d")LocalDate date);

    @Query(value = "SELECT sum(o.cost) FROM Order o WHERE o.orderDate=:d ")
    String dailyIncome(@Param("d") LocalDate date);
}
