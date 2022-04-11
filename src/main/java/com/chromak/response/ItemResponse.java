package com.chromak.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemResponse {

    private String itemName;

    private int itemCount;

    public ItemResponse(String itemName, int itemCount) {
        this.itemName = itemName;
        this.itemCount = itemCount;
    }
}
