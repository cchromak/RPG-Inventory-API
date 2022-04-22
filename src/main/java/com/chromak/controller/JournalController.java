package com.chromak.controller;

import com.chromak.entity.Journal;
import com.chromak.request.CreateJournalRequest;
import com.chromak.request.UpdateJournalRequest;
import com.chromak.response.JournalResponse;
import com.chromak.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/journal/")
public class JournalController {

    @Autowired
    JournalService journalService;

    @PostMapping("createEntry")
    private JournalResponse createEntry(@RequestBody CreateJournalRequest createJournalRequest) {
        Journal journal = journalService.createEntry(createJournalRequest);
        JournalResponse journalResponse = new JournalResponse(journal.getId(), journal.getPlayer().getId(), journal.getEntry(), journal.getTimestamp());
        return journalResponse;
    }

    @PutMapping("updateEntry")
    private JournalResponse updateEntry(@RequestBody UpdateJournalRequest updateJournalRequest) {
        Journal journal = journalService.updateEntry(updateJournalRequest);
        JournalResponse journalResponse = new JournalResponse(journal.getId(), journal.getPlayer().getId(), journal.getEntry(), journal.getTimestamp());
        return journalResponse;
    }

    @GetMapping("getAll/{id}")
    private List<JournalResponse> getAllByPlayerId(@PathVariable Long id) {
        List<Journal> journalList = journalService.getAllByPlayerId(id);
        List<JournalResponse> journalResponseList = new ArrayList<>();
        for(Journal journal: journalList) {
            journalResponseList.add(new JournalResponse(journal.getId(), journal.getPlayer().getId(), journal.getEntry(), journal.getTimestamp()));
        }
        return journalResponseList;
    }

    @DeleteMapping("delete/{id}")
    private String deleteEntry(@PathVariable Long id) {
        String message = journalService.deleteEntry(id);
        return message;
    }

}
