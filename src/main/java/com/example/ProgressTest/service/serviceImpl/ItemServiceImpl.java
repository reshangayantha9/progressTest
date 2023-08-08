package com.example.ProgressTest.service.serviceImpl;

import com.example.ProgressTest.entity.Item;
import com.example.ProgressTest.repository.ItemRepository;
import com.example.ProgressTest.entity.idGenerator.ItemBarCode;
import com.example.ProgressTest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        String code = itemBarCode.generateBarcode(item.getDescription());
        item.setBarcode(code.getBytes());
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

    @Override
    public Page<Item> findByPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Item> items=itemRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
        return items;
    }
}
