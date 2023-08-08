package com.example.ProgressTest.repository;
import com.example.ProgressTest.entity.OrderHasItem;
import com.example.ProgressTest.entity.idGenerator.OrderHasItemPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderHasItemRepository extends JpaRepository<OrderHasItem, OrderHasItemPK> {
}
