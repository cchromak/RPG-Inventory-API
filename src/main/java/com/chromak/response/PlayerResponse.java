package com.chromak.response;

import com.chromak.entity.Item;
import com.chromak.entity.Player;
import com.chromak.entity.PlayerItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PlayerResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String homePlanet;

    private String quote;

    private Set<ItemResponse> items;

    private Set<StatResponse> statResponseList;

    public PlayerResponse(Player player) {
        this.id = player.getId();
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();
        this.homePlanet = player.getHomePlanet();
        this.quote = player.getQuote();
        if (player.getPlayerItems() != null) {
            this.items = new HashSet<ItemResponse>();
            player.getPlayerItems().stream().forEach(playerItem -> {
                this.items.add(new ItemResponse(playerItem.getItem().getItemName(), playerItem.getItemCount()));
            });
        }

        if (player.getPlayerStats() != null) {
            this.statResponseList = new HashSet<StatResponse>();
            player.getPlayerStats().stream().forEach(playerStats -> {
                this.statResponseList.add(new StatResponse(playerStats.getStats().getStatsName(), playerStats.getDiceRoll(), playerStats.getBonusRoll()));
            });
        }

    }

}
