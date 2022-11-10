package br.com.crp.handeballCamp.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="matchs")
public class Match implements Comparable<Match>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String date;
    private Date data;
    private int homeGoals;
    private int visitorGoals;
    @ManyToOne
    private Team visitorTeam;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Stadium stadium;
    private  Boolean over = false;

    public Match() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Match(String date, Team homeTeam, Team visitorTeam, Stadium stadium) {
        this.date = date;
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
        this.stadium = stadium;
    }
    public Match(Long id, String date, Team homeTeam, Team visitorTeam, Stadium stadium) {
        this.id = id;
        this.date = date;
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
        this.stadium = stadium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam(Team visitorTeam) {
        this.visitorTeam = visitorTeam;
    }

    public int getVisitorGoals() {
        return visitorGoals;
    }

    public void setVisitorGoals(int visitorGoals) {
        this.visitorGoals = visitorGoals;
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

    public void gameOver(int i, int i1) {
        if(homeGoals>visitorGoals){//caso o time da casa ganha
            this.homeTeam.addPoints(2);
        }
        if(homeGoals<visitorGoals){//caso o time da casa perca
            this.visitorTeam.addPoints(2);
        }if(homeGoals==visitorGoals){//caso empata
            this.visitorTeam.addPoints(1);
            this.homeTeam.addPoints(1);
        }
        this.homeGoals=homeGoals;
        this.visitorGoals=visitorGoals;
        this.homeTeam.addGoals(homeGoals);
        this.visitorTeam.addGoals(visitorGoals);
        this.over=true;
    }

    @Override
    public int compareTo(Match o) {
        if (getData() == null || o.getData() == null)
            return 0;
        return getData().compareTo(o.getData());
    }
}
