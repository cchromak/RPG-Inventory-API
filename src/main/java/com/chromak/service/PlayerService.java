package com.chromak.service;

import com.chromak.entity.Item;
import com.chromak.entity.Player;
import com.chromak.entity.PlayerItem;
import com.chromak.entity.PlayerItemKey;
import com.chromak.repository.ItemRepository;
import com.chromak.repository.PlayerItemRepository;
import com.chromak.repository.PlayerRepository;
import com.chromak.request.CreateItemRequest;
import com.chromak.request.CreatePlayerRequest;
import com.chromak.request.UpdatePlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PlayerItemRepository playerItemRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player createPlayer(CreatePlayerRequest createPlayerRequest) {
        // Create and save new player
        Player player = new Player(createPlayerRequest);
        player = playerRepository.save(player);
        // Local set to store playerItems to set for player object at end of loop.
        Set<PlayerItem> playerItems = new HashSet<PlayerItem>();

        if (createPlayerRequest.getItems() != null) {
            for (CreateItemRequest createItemRequest : createPlayerRequest.getItems()) {
                // Create Item if it does not exist and save to table
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

                // create PlayerItem, set all fields and save
                PlayerItem playerItem = new PlayerItem();
                playerItem.setId(playerItemKey);
                playerItem.setPlayer(player);
                playerItem.setItem(item);
                playerItem.setItemCount(createItemRequest.getItemCount());
                playerItemRepository.save(playerItem);
                playerItems.add(playerItem);
            }
        }
        player.setPlayerItems(playerItems);
        return playerRepository.save(player);
    }

    public Player updatePlayer(UpdatePlayerRequest updatePlayerRequest) {
        Player player = playerRepository.findById(updatePlayerRequest.getId()).get();

        if (updatePlayerRequest.getFirstName() != null && !updatePlayerRequest.getFirstName().isEmpty()) {
            player.setFirstName(updatePlayerRequest.getFirstName());
        }

        if (updatePlayerRequest.getLastName() != null && !updatePlayerRequest.getLastName().isEmpty()) {
            player.setLastName(updatePlayerRequest.getLastName());
        }

        if (updatePlayerRequest.getHomePlanet() != null && !updatePlayerRequest.getHomePlanet().isEmpty()) {
            player.setHomePlanet(updatePlayerRequest.getHomePlanet());
        }

        if (updatePlayerRequest.getQuote() != null && !updatePlayerRequest.getQuote().isEmpty()) {
            player.setQuote(updatePlayerRequest.getQuote());
        }

        return playerRepository.save(player);
    }

    public String deletePlayer(Long id) {
        playerRepository.deleteById(id);
        return "Player with id (" + id + ") has been deleted.";
    }
}
