package com.chromak.service;

import com.chromak.entity.*;
import com.chromak.repository.*;
import com.chromak.request.CreateItemRequest;
import com.chromak.request.CreatePlayerRequest;
import com.chromak.request.CreateStatsRequest;
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

    @Autowired
    StatsRepository statsRepository;

    @Autowired
    PlayerStatsRepository playerStatsRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getById(Long id) {
        return playerRepository.getById(id);
    }

    public Player createPlayer(CreatePlayerRequest createPlayerRequest) {
        // Create and save new player
        Player player = new Player(createPlayerRequest);
        player = playerRepository.save(player);
        // Local sets to store playerItems and playerStats to set for player object at end of loop.
        Set<PlayerItem> playerItems = new HashSet<PlayerItem>();
        Set<PlayerStats> playerStats = new HashSet<PlayerStats>();

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
            player.setPlayerItems(playerItems);
        }

        player = playerRepository.save(player);

        if (createPlayerRequest.getStats() != null && createPlayerRequest.getStats().size() > 0) {
            for (CreateStatsRequest createStatsRequest: createPlayerRequest.getStats()) {
                Stats stat = statsRepository.findStatsByStatsName(createStatsRequest.getStatName());
                if (stat == null) {
                    stat = new Stats();
                    stat.setStatsName(createStatsRequest.getStatName());
                    stat = statsRepository.save(stat);
                }

                // Set PlayerStatsKey
                PlayerStatsKey playerStatsKey = new PlayerStatsKey();
                playerStatsKey.setPlayerId(player.getId());
                playerStatsKey.setStatsId(stat.getId());

                //
                PlayerStats playerStat = new PlayerStats();
                playerStat.setId(playerStatsKey);
                playerStat.setPlayer(player);
                playerStat.setStats(stat);
                playerStat.setDiceRoll(createStatsRequest.getDiceRoll());
                playerStat.setBonusRoll(createStatsRequest.getBonusRoll());
                playerStatsRepository.save(playerStat);
                playerStats.add(playerStat);
            }
            player.setPlayerStats(playerStats);
        }
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
