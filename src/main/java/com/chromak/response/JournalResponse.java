package com.chromak.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class JournalResponse {

    private Long id;

    private Long playerId;

    private String entry;

    private Date timestamp;

    public JournalResponse(Long id, Long playerId, String entry, Date timestamp) {
        this.id = id;
        this.playerId = playerId;
        this.entry = entry;
        this.timestamp = timestamp;
    }
}
