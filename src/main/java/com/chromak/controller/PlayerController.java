package com.chromak.controller;

import com.chromak.entity.Player;
import com.chromak.request.CreateItemRequest;
import com.chromak.request.CreatePlayerRequest;
import com.chromak.request.UpdatePlayerRequest;
import com.chromak.response.ItemResponse;
import com.chromak.response.PlayerResponse;
import com.chromak.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/player/")
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @GetMapping("getAll")
    public List<PlayerResponse> getAllPlayers() {
        List<Player> playerList = playerService.getAllPlayers();
        List<PlayerResponse> playerResponseList = new ArrayList<PlayerResponse>();
        for (Player player: playerList) {
            playerResponseList.add(new PlayerResponse(player));
        }
        return  playerResponseList;
    }

    @GetMapping("getById/{id}")
    public PlayerResponse getById(@PathVariable Long id) {
        Player player = playerService.getById(id);
        PlayerResponse playerResponse = new PlayerResponse(player);
        return playerResponse;
    }

    @PostMapping("create")
    public PlayerResponse createPlayer(@Valid @RequestBody CreatePlayerRequest createPlayerRequest) {
        Player player = playerService.createPlayer(createPlayerRequest);
        PlayerResponse playerResponse = new PlayerResponse(player);
        return playerResponse;
    }

    @PutMapping("update")
    public PlayerResponse updatePlayer(@Valid @RequestBody UpdatePlayerRequest updatePlayerRequest) {
        Player player = playerService.updatePlayer(updatePlayerRequest);
        PlayerResponse playerResponse = new PlayerResponse(player);
        return playerResponse;
    }

    @DeleteMapping("delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
        return playerService.deletePlayer(id);
    }

}
