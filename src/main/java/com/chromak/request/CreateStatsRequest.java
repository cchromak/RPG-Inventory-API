package com.chromak.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStatsRequest {

    private String statName;

    private int diceRoll;

    private int bonusRoll;

}
