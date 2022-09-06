package com.example.Test.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name,date,jenre;
    Integer cena,prodajKopii;

    public Games(String name, String date, String jenre, Integer cena, Integer prodajKopii) {
        this.name = name;
        this.date = date;
        this.jenre = jenre;
        this.cena = cena;
        this.prodajKopii = prodajKopii;
    }

    public Games() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJenre() {
        return jenre;
    }

    public void setJenre(String jenre) {
        this.jenre = jenre;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Integer getProdajKopii() {
        return prodajKopii;
    }

    public void setProdajKopii(Integer prodajKopii) {
        this.prodajKopii = prodajKopii;
    }
}
