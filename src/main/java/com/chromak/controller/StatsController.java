package com.chromak.controller;

import com.chromak.entity.Stats;
import com.chromak.request.UpdateStatsRequest;
import com.chromak.response.StatResponse;
import com.chromak.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats/")
public class StatsController {

    @Autowired
    StatsService statsService;

    @PostMapping("create/{statName}")
    public String createStat(@PathVariable String statName) {
        Stats stat = statsService.createStat(statName);
        return stat.getStatsName() +  " was created.";
    }

    @DeleteMapping("delete/{statsName}")
    public String deleteByStatsName(@PathVariable String statsName) {
        return statsService.deleteByStatsName(statsName) +  " stat(s) was deleted.";
    }

    @PutMapping("updateStatForPlayer")
    public StatResponse updateStatForPlayer(@RequestBody UpdateStatsRequest updateStatsRequest) {
        return statsService.updateStatForPlayer(updateStatsRequest);
    }

}
