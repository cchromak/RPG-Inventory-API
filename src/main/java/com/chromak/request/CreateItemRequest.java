package com.chromak.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateItemRequest {

    private String itemName;

    private int itemCount;

}
