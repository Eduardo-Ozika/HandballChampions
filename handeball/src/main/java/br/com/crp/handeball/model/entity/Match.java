package br.com.crp.handeball.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PARTIDAS")
public class Match implements Comparable<Match>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private Date date;
    @Column(name = "HOMEGOALS")
    private int homeGoals;
    @Column(name = "VISITORGOALS")
    private int visitorGoals;

    private  Boolean over = false;
    @ManyToOne
    @JoinColumn(name="teamhome_id")
    private Team teamhome;
    @ManyToOne
    @JoinColumn(name="teamvisitor_id")
    private Team teamvisitor;

    @ManyToOne
    private Stadium stadium;

    public Match() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getVisitorGoals() {
        return visitorGoals;
    }

    public void setVisitorGoals(int visitorGoals) {
        this.visitorGoals = visitorGoals;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getTeamhome() {
        return teamhome;
    }

    public void setTeamhome(Team teamhome) {
        this.teamhome = teamhome;
    }

    public Team getTeamvisitor() {
        return teamvisitor;
    }

    public void setTeamvisitor(Team teamvisitor) {
        this.teamvisitor = teamvisitor;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Boolean getOver() {
        return over;
    }

    public void setOver(Boolean over) {
        this.over = over;
    }

    @Override
    public int compareTo(Match o) {
        if (getDate() == null || o.getDate() == null)
            return 0;
        return getDate().compareTo(o.getDate());
    }
}
