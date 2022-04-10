package com.chromak.service;

import com.chromak.entity.Player;
import com.chromak.repository.PlayerRepository;
import com.chromak.request.CreatePlayerRequest;
import com.chromak.request.UpdatePlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player createPlayer(CreatePlayerRequest createPlayerRequest) {
        Player player = new Player(createPlayerRequest);
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
}
