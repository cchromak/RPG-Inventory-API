package com.chromak.repository;

import com.chromak.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying
    @Transactional
    @Query("Delete Item where itemName = :itemName")
    Integer deleteByItemName(String itemName);

    @Query("From Item where itemName = :itemName")
    Item findItemByItemName(String itemName);
}
