package com.chromak.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player_items")
public class PlayerItem {

    @EmbeddedId
    PlayerItemKey id;

    @ManyToOne
    @MapsId("playerId")
    @JoinColumn(name = "id_player")
    Player player;

    @ManyToOne
    @MapsId("itemsId")
    @JoinColumn(name = "id_items")
    Item item;

    @Column(name = "item_count")
    int itemCount;

}
