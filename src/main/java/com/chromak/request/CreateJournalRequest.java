package com.chromak.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateJournalRequest {

    private long playerId;

    private String entry;
}
