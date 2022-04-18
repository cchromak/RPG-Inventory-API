package com.chromak.service;

import com.chromak.entity.Item;
import com.chromak.entity.Player;
import com.chromak.entity.PlayerItem;
import com.chromak.entity.PlayerItemKey;
import com.chromak.repository.ItemRepository;
import com.chromak.repository.PlayerItemRepository;
import com.chromak.repository.PlayerRepository;
import com.chromak.request.CreateItemRequest;
import com.chromak.response.ItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerItemRepository playerItemRepository;

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
}
