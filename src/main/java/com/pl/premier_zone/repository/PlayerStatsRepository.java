package com.pl.premier_zone.repository;

import com.pl.premier_zone.player.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
    List<PlayerStats> findByTeamName(String teamName);
    List<PlayerStats> findTop10ByGoalsIsNotNullOrderByGoalsDesc();
    List<PlayerStats> findByPlayerNameContainingIgnoreCase(String name);

}