package com.chromak.service;

import com.chromak.entity.Player;
import com.chromak.entity.PlayerStats;
import com.chromak.entity.PlayerStatsKey;
import com.chromak.entity.Stats;
import com.chromak.repository.PlayerRepository;
import com.chromak.repository.PlayerStatsRepository;
import com.chromak.repository.StatsRepository;
import com.chromak.request.CreateStatsRequest;
import com.chromak.request.UpdateStatsRequest;
import com.chromak.response.StatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    StatsRepository statsRepository;

    @Autowired
    PlayerStatsRepository playerStatsRepository;

    @Autowired
    PlayerRepository playerRepository;


    public Stats createStat(String statName) {
        return statsRepository.save(new Stats(statName));
    }

    public Integer deleteByStatsName(String statsName) {
        return statsRepository.deleteByStatName(statsName);
    }

    public StatResponse addStatForPlayer(CreateStatsRequest createStatsRequest) {
        Player player = playerRepository.getById(createStatsRequest.getPlayerId());

        Stats stats = statsRepository.findStatsByStatsName(createStatsRequest.getStatName());
        if (stats == null) {
            stats = new Stats(createStatsRequest.getStatName());
            stats = statsRepository.save(stats);
        }

        PlayerStatsKey playerStatsKey = new PlayerStatsKey(player.getId(), stats.getId());

        PlayerStats playerStats = new PlayerStats();
        playerStats.setId(playerStatsKey);
        playerStats.setPlayer(player);
        playerStats.setStats(stats);
        playerStats.setDiceRoll(createStatsRequest.getDiceRoll());
        playerStats.setBonusRoll(createStatsRequest.getBonusRoll());
        playerStats = playerStatsRepository.save(playerStats);

        StatResponse statResponse = new StatResponse(playerStats.getStats().getStatsName(), playerStats.getDiceRoll(), playerStats.getBonusRoll());
        return statResponse;
    }

    public StatResponse updateStatForPlayer(UpdateStatsRequest updateStatsRequest) {
        Player player = playerRepository.getById(updateStatsRequest.getPlayerId());

        Stats stats = statsRepository.findStatsByStatsName(updateStatsRequest.getStatName());

        PlayerStats playerStats = playerStatsRepository.getById(new PlayerStatsKey(player.getId(), stats.getId()));

        if (playerStats.getDiceRoll() != updateStatsRequest.getDiceRoll()) {
            playerStats.setDiceRoll(updateStatsRequest.getDiceRoll());
        }

        if (playerStats.getBonusRoll() != updateStatsRequest.getBonusRoll()) {
            playerStats.setBonusRoll(updateStatsRequest.getBonusRoll());
        }

        playerStats = playerStatsRepository.save(playerStats);

        StatResponse statResponse = new StatResponse(playerStats.getStats().getStatsName(), playerStats.getDiceRoll(), playerStats.getBonusRoll());
        return statResponse;
    }


}
