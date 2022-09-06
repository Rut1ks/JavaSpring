package com.example.Test.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarsMarket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name, date;

    Integer kolichestvo, cena, moshnost;

    public CarsMarket(String name, String date, Integer kolichestvo, Integer cena, Integer moshnost) {
        this.name = name;
        this.date = date;
        this.kolichestvo = kolichestvo;
        this.cena = cena;
        this.moshnost = moshnost;
    }

    public CarsMarket() {
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

    public Integer getKolichestvo() {
        return kolichestvo;
    }

    public void setKolichestvo(Integer kolichestvo) {
        this.kolichestvo = kolichestvo;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public Integer getMoshnost() {
        return moshnost;
    }

    public void setMoshnost(Integer moshnost) {
        this.moshnost = moshnost;
    }
}
