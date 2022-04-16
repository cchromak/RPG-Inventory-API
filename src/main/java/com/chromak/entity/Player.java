package com.chromak.entity;


import com.chromak.request.CreatePlayerRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "home_planet")
    private String homePlanet;

    @Column(name = "quote")
    private String quote;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    Set<PlayerItem> playerItems;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    Set<PlayerStats> playerStats;


    public Player(CreatePlayerRequest createPlayerRequest) {
        this.firstName = createPlayerRequest.getFirstName();
        this.lastName = createPlayerRequest.getLastName();
        this.homePlanet = createPlayerRequest.getHomePlanet();
        this.quote = createPlayerRequest.getQuote();
    }

}
