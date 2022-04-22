package com.chromak.repository;

import com.chromak.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {

    @Query("From Journal where player.id = :id")
    List<Journal> findAllByIdPlayerId(Long id);

}
