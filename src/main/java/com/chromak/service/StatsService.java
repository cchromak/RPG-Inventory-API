package com.chromak.service;

import com.chromak.entity.Stats;
import com.chromak.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    StatsRepository statsRepository;


    public Stats createStat(String statName) {
        return statsRepository.save(new Stats(statName));
    }

    public Integer deleteByStatsName(String statsName) {
        return statsRepository.deleteByStatName(statsName);
    }
}
