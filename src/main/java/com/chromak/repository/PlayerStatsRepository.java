package com.chromak.repository;

import com.chromak.entity.PlayerStats;
import com.chromak.entity.PlayerStatsKey;
import com.chromak.request.UpdateStatsRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStats, PlayerStatsKey> {

    PlayerStats getById(PlayerStatsKey playerStatsKey);

}
