package com.pl.premier_zone.player;

import jakarta.persistence.*;

@Entity
@Table(name = "player_statistics")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    private String nation;
    private String position;
    private String age;

    @Column(name = "matches_played")
    private Integer matchesPlayed;

    private Float goals;
    private Float assists;

    @Column(name = "yellow_cards")
    private Float yellowCards;

    @Column(name = "red_cards")
    private Float redCards;

    @Column(name = "team_name")
    private String teamName;

    public Long getId() { return id; }
    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }
    public String getNation() { return nation; }
    public void setNation(String nation) { this.nation = nation; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    public Integer getMatchesPlayed() { return matchesPlayed; }
    public void setMatchesPlayed(Integer matchesPlayed) { this.matchesPlayed = matchesPlayed; }
    public Float getGoals() { return goals; }
    public void setGoals(Float goals) { this.goals = goals; }
    public Float getAssists() { return assists; }
    public void setAssists(Float assists) { this.assists = assists; }
    public Float getYellowCards() { return yellowCards; }
    public void setYellowCards(Float yellowCards) { this.yellowCards = yellowCards; }
    public Float getRedCards() { return redCards; }
    public void setRedCards(Float redCards) { this.redCards = redCards; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
}