package com.chromak.controller;

import com.chromak.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item/")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("create/{itemName}")
    public String createItem(@PathVariable String itemName) {
        return itemService.createItem(itemName).getItemName() + " was created.";
    }

    @DeleteMapping("delete/{itemName}")
    public String deleteByItemName(@PathVariable String itemName) {
        return itemService.deleteByItemName(itemName) + " item(s) where deleted.";
    }
}
