package br.com.crp.handeball.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name="TEAMS")
public class Team implements Comparable<Team>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();
    @OneToOne
    private Stadium stadium;
    private int points;
    private int goals;
    @ManyToOne
    private Championship cahampionship;

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public Championship getCahampionship() {
        return cahampionship;
    }

    public void setCahampionship(Championship cahampionship) {
        this.cahampionship = cahampionship;
    }

    @Override
    public int compareTo(Team team) {
        if(team.getPoints()==this.points)
            return (team.getGoals()-this.goals);
        return (team.getPoints()-this.points);
    }
}
