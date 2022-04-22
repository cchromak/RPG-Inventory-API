package com.chromak.service;


import com.chromak.entity.Journal;
import com.chromak.entity.Player;
import com.chromak.repository.JournalRepository;
import com.chromak.repository.PlayerRepository;
import com.chromak.request.CreateJournalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class JournalService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    JournalRepository journalRepository;


    public Journal createEntry(CreateJournalRequest createJournalRequest) {
        Player player = playerRepository.getById(createJournalRequest.getPlayerId());

        Journal journal = new Journal();
        journal.setPlayer(player);
        journal.setEntry(createJournalRequest.getEntry());

        journal = journalRepository.save(journal);

        player.getPlayerJournal().add(journal);
        playerRepository.save(player);
        return journal;
    }
}
