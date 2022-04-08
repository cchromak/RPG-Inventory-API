package com.chromak.controller;

import com.chromak.entity.Player;
import com.chromak.response.PlayerResponse;
import com.chromak.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
