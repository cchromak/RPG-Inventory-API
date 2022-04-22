package com.chromak.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateJournalRequest {

    private long id;

    private long playerId;

    private String entry;

}
