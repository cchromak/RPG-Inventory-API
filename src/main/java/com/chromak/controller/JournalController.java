package com.chromak.controller;

import com.chromak.entity.Journal;
import com.chromak.request.CreateJournalRequest;
import com.chromak.response.JournalResponse;
import com.chromak.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
