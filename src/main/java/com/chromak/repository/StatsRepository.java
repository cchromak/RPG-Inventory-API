package com.chromak.repository;

import com.chromak.entity.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {

    @Modifying
    @Transactional
    @Query("Delete Stats where statsName = :statsName")
    Integer deleteByStatName(String statsName);

    @Query("From Stats where statsName = :statsName")
    Stats findStatsByStatsName(String statsName);

}
