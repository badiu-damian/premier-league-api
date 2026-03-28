package com.pl.premier_zone.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.pl.premier_zone.player.PlayerStats;
import com.pl.premier_zone.repository.PlayerStatsRepository;
@Service
public class PlayerServiceImplementation implements PlayerService{
    @Autowired
    private PlayerStatsRepository repository;

    @Override
    public List<PlayerStats> getAllPlayers(){
        return repository.findAll();
    }
    @Override
    public List<PlayerStats> getPlayersByTeam(String teamName){
        return repository.findByTeamName(teamName);

    }
    @Override
    public List<PlayerStats> getTopScorers(){
        return repository.findTop10ByGoalsIsNotNullOrderByGoalsDesc();
    }
    @Override
    public List<PlayerStats> searchByName(String name){
        return repository.findByPlayerNameContainingIgnoreCase(name);

    }
}
