package br.com.crp.handeballCamp.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name="teams")
public class Team implements Comparable<Team>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @OneToMany
    private List<Player> players = new ArrayList<>();
    private TipoJogador tipoJogador;
    @OneToOne
    private Stadium homeStadium;
    private int points;
    private int goals;

    public Team() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team(String name, TipoJogador tipoJogador, Stadium homeStadium) {
        this.name = name;
        this.tipoJogador = tipoJogador;
        this.homeStadium = homeStadium;
        this.points = 0;
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

    public TipoJogador getCaptain() {
        return tipoJogador;
    }

    public void setCaptain(TipoJogador tipoJogador) {
        this.tipoJogador = tipoJogador;
    }

    public Stadium getStadium() {
        return homeStadium;
    }

    public void setStadium(Stadium Stadium) {
        this.homeStadium = Stadium;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public void addPoints(int points){
        this.points += points;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public void addGoals(int goals) {
        this.goals += goals;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String name) {
        for (int i=0; i<this.players.size();i++){
            if(players.get(i).getName().equalsIgnoreCase(name)){
                players.remove(i);
            }
        }
    }
    public void removePlayer(Player player) {
        this.players.remove(player);
    }
    public void listPlayers(){
        Collections.sort(this.players);
        System.out.println("Nome | Data de Nascimento | Genero | Altura");
        for (Player p: this.players) {
            System.out.println(p.toString());
        }
    }

    @Override
    public int compareTo(Team team) {
        if(team.getPoints()==this.points)
            return (team.getGoals()-this.goals);
        return (team.getPoints()-this.points);
    }
}
