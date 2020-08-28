package com.example.vezba11.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(nullable = false, columnDefinition = "date")
    private LocalDateTime odKad;
    @Column(nullable = false, columnDefinition = "date")
    private LocalDateTime doKad;

    @ManyToOne
    Gost gost;

    @ManyToOne
    Soba soba;

    public Rezervacija(){
        super();
    }

    public Rezervacija(Long id,LocalDateTime odKad,LocalDateTime doKad,Gost gost,Soba soba){
        this.id = id;
        this.odKad = odKad;
        this.doKad = doKad;
        this.gost = gost;
        this.soba = soba;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getOdKad() {
        return odKad;
    }

    public void setOdKad(LocalDateTime odKad) {
        this.odKad = odKad;
    }

    public LocalDateTime getDoKad() {
        return doKad;
    }

    public void setDoKad(LocalDateTime doKad) {
        this.doKad = doKad;
    }

    public Gost getGost() {
        return gost;
    }

    public void setGost(Gost gost) {
        this.gost = gost;
    }

    public Soba getSoba() {
        return soba;
    }

    public void setSoba(Soba soba) {
        this.soba = soba;
    }
}
