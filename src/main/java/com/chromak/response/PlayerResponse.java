package com.chromak.response;

import com.chromak.entity.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class PlayerResponse {

    private Long id;

    private String playerName;

    private String homePlanet;

    private String quote;

    public PlayerResponse(Player player) {
        this.id = player.getId();
        this.playerName = player.getPlayerName();
        this.homePlanet = player.getHomePlanet();
        this.quote = player.getQuote();
    }

}
