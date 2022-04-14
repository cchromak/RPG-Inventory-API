package com.chromak.service;

import com.chromak.entity.Item;
import com.chromak.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item createItem(String itemName) {
        return itemRepository.save(new Item(itemName));
    }

    public Integer deleteByItemName(String itemName) {
        return itemRepository.deleteByItemName(itemName);
    }
}
