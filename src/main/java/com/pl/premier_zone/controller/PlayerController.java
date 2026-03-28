package com.pl.premier_zone.controller;

import com.pl.premier_zone.player.PlayerStats;
import com.pl.premier_zone.repository.PlayerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerStatsRepository repository;

    @GetMapping
    public List<PlayerStats> getAllPlayers() {
        return repository.findAll();
    }

    @GetMapping("/team/{teamName}")
    public List<PlayerStats> getByTeam(@PathVariable String teamName) {
        return repository.findByTeamName(teamName);
    }
    @GetMapping("/top-scorers")
    public List<PlayerStats> getTopScorers(){
        return repository.findTop10ByGoalsIsNotNullOrderByGoalsDesc();
    }
@GetMapping("/search")
    public List<PlayerStats> searchByName(@RequestParam String name){
    return repository.findByPlayerNameContainingIgnoreCase(name);
}

}