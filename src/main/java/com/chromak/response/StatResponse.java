package com.chromak.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatResponse {

    private Long id;

    private String statName;

    private int diceRoll;

    private int bonusRoll;

    public StatResponse(String statName, int diceRoll, int bonusRoll) {
        this.statName = statName;
        this.diceRoll = diceRoll;
        this.bonusRoll = bonusRoll;
    }

    public StatResponse(Long id, String statName) {
        this.id = id;
        this.statName = statName;
    }
}
