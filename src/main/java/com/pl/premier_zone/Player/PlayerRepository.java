package com.pl.premier_zone.Player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Indicates that this is a spring data repository and extends JpaRepository which
// Provides CRUD for the entiry which is Player and its primary key of String
@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
    void deleteByName(String playerName);
    Optional<Player> findByName(String name);
}

