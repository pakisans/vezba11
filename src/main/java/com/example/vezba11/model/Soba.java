package com.example.vezba11.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Soba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,columnDefinition = "text")
    private String naziv;

    @Column(nullable = false,columnDefinition = "text")
    private String opis;

    @Column(nullable = false,columnDefinition = "text")
    private Long brojKreveta;

    @OneToMany(mappedBy = "soba",cascade = CascadeType.REMOVE)
    private List<Rezervacija> rezervacija;

    public Soba(){
        super();
    }

    public Soba(long id,String naziv,String opis,Long brojKreveta,List<Rezervacija> rezervacija){
        super();
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.brojKreveta = brojKreveta;
        this.rezervacija = rezervacija;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(Long brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public List<Rezervacija> getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(List<Rezervacija> rezervacija) {
        this.rezervacija = rezervacija;
    }
}
