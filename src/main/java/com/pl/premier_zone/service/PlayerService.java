package com.pl.premier_zone.service;

import com.pl.premier_zone.player.PlayerStats;
import java.util.List;

public interface PlayerService {

    // Returneaza toti jucatorii
    List<PlayerStats> getAllPlayers();

    // Returneaza jucatorii dintr-o echipa
    List<PlayerStats> getPlayersByTeam(String teamName);

    // Returneaza top 10 marcatori
    List<PlayerStats> getTopScorers();

    // Cauta jucator dupa nume
    List<PlayerStats> searchByName(String name);
}