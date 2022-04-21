package com.chromak.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemResponse {

    private Long id;

    private String itemName;

    private int itemCount;

    public ItemResponse(String itemName, int itemCount) {
        this.itemName = itemName;
        this.itemCount = itemCount;
    }

    public ItemResponse(Long id, String itemName) {
        this.id = id;
        this.itemName = itemName;
    }
}
