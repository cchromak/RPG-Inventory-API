package com.chromak.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePlayerItem {

    private long playerId;

    private String itemName;

    private int itemCount;

}
