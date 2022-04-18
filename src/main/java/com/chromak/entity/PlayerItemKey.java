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
public class PlayerItemKey implements Serializable {

    @Column(name = "id_player")
    Long playerId;

    @Column(name = "id_items")
    Long itemsId;

    public PlayerItemKey(Long playerId, Long itemsId) {
        this.playerId = playerId;
        this.itemsId = itemsId;
    }
}
