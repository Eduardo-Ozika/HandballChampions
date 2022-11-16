package br.com.crp.handeballCamp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player implements Comparable<Player>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String birthDate;
    private Gender gender;
    private Double height;
    private Double weight;
    @Enumerated(EnumType.STRING)
    TipoJogador tipo = TipoJogador.PLAYER;
    @ManyToOne
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player(String name, String birthDate, Gender gender, Double height, Team team, Double weight) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.height = height;
        this.team = team;
        this.weight=weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public TipoJogador getTipo() {
        return tipo;
    }

    public void setTipo(TipoJogador tipo) {
        this.tipo = tipo;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public int compareTo(Player player2) {
        return this.name.compareTo(player2.getName());
    }
    @Override
    public String toString(){return("Jogador: "+ this.name+" "+this.birthDate+" "+this.gender+" "+this.height);}
}
