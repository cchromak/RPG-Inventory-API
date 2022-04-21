package com.chromak.service;

import com.chromak.entity.Item;
import com.chromak.entity.Player;
import com.chromak.entity.PlayerItem;
import com.chromak.entity.PlayerItemKey;
import com.chromak.repository.ItemRepository;
import com.chromak.repository.PlayerItemRepository;
import com.chromak.repository.PlayerRepository;
import com.chromak.request.CreateItemRequest;
import com.chromak.request.UpdatePlayerItem;
import com.chromak.response.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerItemRepository playerItemRepository;


    public List<ItemResponse> getAll() {
        List<Item> items =  itemRepository.findAll();
        List<ItemResponse> itemsList = new ArrayList<>();
        for (Item item: items) {
            itemsList.add(new ItemResponse(item.getId(), item.getItemName()));
        }
        return itemsList;
    }

    public Item createItem(String itemName) {
        return itemRepository.save(new Item(itemName));
    }

    public Integer deleteByItemName(String itemName) {
        return itemRepository.deleteByItemName(itemName);
    }

    public ItemResponse addItemToPlayer(CreateItemRequest createItemRequest) {
        Player player = playerRepository.getById(createItemRequest.getPlayerId());
        // Need to throw error here if player not found

        Item item = itemRepository.findItemByItemName(createItemRequest.getItemName());
        if (item == null) {
            item = new Item();
            item.setItemName(createItemRequest.getItemName());
            item = itemRepository.save(item);
        }

        // Create playerItemKey
        PlayerItemKey playerItemKey = new PlayerItemKey();
        playerItemKey.setPlayerId(player.getId());
        playerItemKey.setItemsId(item.getId());

        player = playerRepository.save(player);

        PlayerItem playerItem = new PlayerItem();
        playerItem.setId(playerItemKey);
        playerItem.setPlayer(player);
        playerItem.setItem(item);
        playerItem.setItemCount(createItemRequest.getItemCount());
        playerItemRepository.save(playerItem);
       // player.getPlayerItems().add(playerItem);

        playerRepository.save(player);

        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setItemName(item.getItemName());
        itemResponse.setItemCount(createItemRequest.getItemCount());
        return itemResponse;

    }

    public ItemResponse updateItemForPlayer(UpdatePlayerItem updatePlayerItem) {
        Player player = playerRepository.getById(updatePlayerItem.getPlayerId());
        // Need to throw error here if player not found.

        Item item = itemRepository.findItemByItemName(updatePlayerItem.getItemName());
        // Need to throw error here if item not found.

        PlayerItem playerItem = playerItemRepository.getById(new PlayerItemKey(player.getId(), item.getId()));
        playerItem.setItemCount(updatePlayerItem.getItemCount());
        playerItem = playerItemRepository.save(playerItem);

        ItemResponse itemResponse = new ItemResponse(playerItem.getItem().getItemName(), playerItem.getItemCount());
        return itemResponse;
    }

}
