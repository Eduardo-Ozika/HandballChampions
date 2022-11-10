package br.com.crp.handeballCamp.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name="championships")
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    @OneToMany
    private List<Match> match = new ArrayList<>();
    @OneToMany
    private List<Team> team = new ArrayList<>();
    @OneToMany
    private List<Stadium> stadium = new ArrayList<>();

    public Championship() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Championship(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Match> getMatch() {
        return match;
    }

    public void setMatch(List<Match> match) {
        this.match = match;
    }

    public void addMatch(Match match){
        this.match.add(match);
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public void addTeam(Team team){
        this.team.add(team);
    }

    public List<Stadium> getStadium() {
        return stadium;
    }

    public void setStadium(List<Stadium> stadium) {
        this.stadium = stadium;
    }

    public void listMatches() {
        System.out.println("Data | Nome do time da casa | Nome do time visitande | Placar = Home:Visitor");
        for (Match m :match) {
            if(m.getOver()==true)
                System.out.println(m.getDate()+" "+m.getHomeTeam().getName()+" VS "+m.getVisitorTeam().getName()+" = "+m.getHomeGoals()+":"+m.getVisitorGoals());
            if(m.getOver()==false)
                System.out.println(m.getDate()+" "+m.getHomeTeam().getName()+" VS "+m.getVisitorTeam().getName());
        }
    }
    public void tableChampionship() {
        Collections.sort(this.team);
        System.out.println("Nome do Time | Classificação | goals");
        for (Team t :this.team) {
            System.out.println(t.getName()+": "+t.getPoints()+" - "+t.getGoals());
        }
    }
    public void listPlayers() {
        for (Team t : this.team) {
            System.out.println("Time:" + t.getName());
            for (Player p : t.getPlayers()) {
                System.out.println(p.toString());
            }
        }
    }
    public Player searchPlayer(String name) {
        for (Team t : this.team) {
            for (Player p : t.getPlayers()) {
                if(p.getName().equalsIgnoreCase(name))
                    return p;
            }
        }
        return null;
    }

    public Team searchTeam(String name) {
        for (Team t: this.team) {
            if(t.getName().equalsIgnoreCase(name))
                return t;
        }
        return null;
    }
    public Stadium searchStadium(String name) {
        for (Stadium s : this.stadium) {
            if(s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }

    public void addStadium(Stadium stadium) {
        this.stadium.add(stadium);
    }
}
