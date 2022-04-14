package com.chromak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "item_name")
    String itemName;

    @OneToMany(mappedBy = "item")
    Set<PlayerItem> playerItems;

    public Item(String itemName) {
        this.itemName = itemName;
    }
}

