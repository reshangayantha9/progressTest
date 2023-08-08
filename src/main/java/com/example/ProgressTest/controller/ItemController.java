package com.example.ProgressTest.controller;

import com.example.ProgressTest.entity.Item;
import com.example.ProgressTest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/main/item")

public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item save(@RequestBody Item item){
        return itemService.save(item);
    }

    @GetMapping
    public List<Item> allItems(){
        return itemService.findAll();
    }
    @GetMapping("/{code}")
    public Optional<Item>getItem(@PathVariable  int code){
        return itemService.findById(code);
    }
    @DeleteMapping("/{code}")
    public void delete(@PathVariable int code){
        itemService.deleteById(code);
    }
    @PutMapping("/{code}")
    public Item update(@PathVariable("code") int code,
                       @RequestBody Item item){
        return itemService.update(code,item);
    }
}
