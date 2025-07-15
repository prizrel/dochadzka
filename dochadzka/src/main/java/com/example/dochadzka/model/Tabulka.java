package com.example.dochadzka.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tabulka")
public class Tabulka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datum;

    private String miesto;

    private LocalTime od;

    @Column(name = "do_time")
    private LocalTime doTime;

    private LocalTime spolu_hod;

    // --- Геттеры и сеттеры ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getMiesto() {
        return miesto;
    }

    public void setMiesto(String miesto) {
        this.miesto = miesto;
    }

    public LocalTime getOd() {
        return od;
    }

    public void setOd(LocalTime od) {
        this.od = od;
    }

    public LocalTime getDoTime() {
        return doTime;
    }

    public void setDoTime(LocalTime doTime) {
        this.doTime = doTime;
    }

    public LocalTime getSpolu_hod() {
        return spolu_hod;
    }

    public void setSpolu_hod(LocalTime spolu_hod) {
        this.spolu_hod = spolu_hod;
    }
}

