package com.example.ProgressTest.service;

import com.example.ProgressTest.entity.Item;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item save(Item item);

    List<Item> findAll();

    Optional<Item> findById(int code);

    void deleteById(int code);

    Item update(int code, Item item);
    Page<Item> findByPaginationAndSorting(int offset, int pageSize, String field);
}
