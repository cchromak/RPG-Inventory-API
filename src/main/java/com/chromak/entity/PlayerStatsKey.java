package com.chromak.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PlayerStatsKey implements Serializable {

    @Column(name = "id_player")
    Long playerId;

    @Column(name = "id_stats")
    Long statsId;

    public PlayerStatsKey(Long playerId, Long statsId) {
        this.playerId = playerId;
        this.statsId = statsId;
    }
}
