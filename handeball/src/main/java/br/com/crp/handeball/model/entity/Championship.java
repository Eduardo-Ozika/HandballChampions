package br.com.crp.handeball.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Entity
@Table(name="CHAMPIONSHIP")
public class Championship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

    public List<Stadium> getStadium() {
        return stadium;
    }

    public void setStadium(List<Stadium> stadium) {
        this.stadium = stadium;
    }


}
