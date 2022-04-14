package com.chromak.repository;

import com.chromak.entity.PlayerItem;
import com.chromak.entity.PlayerItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerItemRepository extends JpaRepository<PlayerItem, PlayerItemKey> {
}
