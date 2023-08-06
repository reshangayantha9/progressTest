package com.example.ProgressTest.service.serviceImpl;

import com.example.ProgressTest.entity.Item;
import com.example.ProgressTest.repository.ItemRepository;
import com.example.ProgressTest.service.ItemBarCode;
import com.example.ProgressTest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemBarCode itemBarCode;
    @Override
    public Item save(Item item) {
        String barcode = itemBarCode.generateBarcode(String.valueOf(item.getCode()));
        //item.setBarcode(barcode.getBytes());
        System.out.println(barcode);
        return itemRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(int code) {
        return itemRepository.findById(code);
    }

    @Override
    public void deleteById(int code) {
        itemRepository.deleteById(code);
    }

    @Override
    public Item update(int code, Item item) {
        Item itemdb=itemRepository.findById(code).get();
        if(Objects.nonNull(item.getQty())){
            itemdb.setQty(item.getQty());
        }
        if(Objects.nonNull(item.getDescription()) &&
                !"".equalsIgnoreCase(item.getDescription())){
            itemdb.setDescription(item.getDescription());
        }
        if(Objects.nonNull(item.getUnitPrice())){
            itemdb.setUnitPrice(item.getUnitPrice());
        }
        System.out.println(itemdb);
        return itemRepository.save(itemdb);
    }
}
