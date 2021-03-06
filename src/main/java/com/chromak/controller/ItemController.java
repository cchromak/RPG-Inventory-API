package com.chromak.controller;

import com.chromak.request.CreateItemRequest;
import com.chromak.request.UpdatePlayerItem;
import com.chromak.response.ItemResponse;
import com.chromak.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item/")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("getAll")
    public List<ItemResponse> getAll() {
        return  itemService.getAll();
    }

    @PostMapping("create/{itemName}")
    public String createItem(@PathVariable String itemName) {
        return itemService.createItem(itemName).getItemName() + " was created.";
    }

    @DeleteMapping("delete/{itemName}")
    public String deleteByItemName(@PathVariable String itemName) {
        return itemService.deleteByItemName(itemName) + " item(s) where deleted.";
    }

    @PostMapping("addItemToPlayer")
    public ItemResponse addItemToPlayer(@RequestBody CreateItemRequest createItemRequest) {
        return itemService.addItemToPlayer(createItemRequest);
    }

    @PutMapping("updateItemForPlayer")
    public ItemResponse updateItemForPlayer(@RequestBody UpdatePlayerItem updatePlayerItem) {
        return  itemService.updateItemForPlayer(updatePlayerItem);
    }

}
