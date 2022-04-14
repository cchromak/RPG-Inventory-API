package com.chromak.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "stats")
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "stats_name")
    String statsName;

    @OneToMany(mappedBy = "stats")
    Set<PlayerStats> playerStats;

    public Stats (String statsName) {
        this.statsName = statsName;
    }

}
