package com.chromak.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player_stats")
public class PlayerStats {

    @EmbeddedId
    PlayerStatsKey id;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "id_player")
    Player player;

    @ManyToOne
    @MapsId("statsId")
    @JoinColumn(name = "id_stats")
    Stats stats;

    @Column(name = "dice_roll")
    int diceRoll;

    @Column(name = "bonus_roll")
    int bonusRoll;
}
