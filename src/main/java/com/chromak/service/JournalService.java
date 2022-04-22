package com.chromak.service;


import com.chromak.entity.Journal;
import com.chromak.entity.Player;
import com.chromak.repository.JournalRepository;
import com.chromak.repository.PlayerRepository;
import com.chromak.request.CreateJournalRequest;
import com.chromak.request.UpdateJournalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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

    public Journal updateEntry(UpdateJournalRequest updateJournalRequest) {
        Journal journal = journalRepository.getById(updateJournalRequest.getId());

        if (updateJournalRequest.getEntry() != null && !journal.getEntry().equals(updateJournalRequest.getEntry())) {
            journal.setEntry(updateJournalRequest.getEntry());
        }

        journal = journalRepository.save(journal);
        return journal;
    }

    public List<Journal> getAllByPlayerId(Long id) {
        List<Journal> journalList = journalRepository.findAllByIdPlayerId(id);
        return journalList;
    }

    public String deleteEntry(Long id) {
        journalRepository.deleteById(id);
        return "Journal entry with id (" + id + ") has been deleted.";
    }

}
