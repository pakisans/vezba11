package com.example.vezba11.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Gost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,columnDefinition = "text")
    private String ime;

    @Column(nullable = false,columnDefinition = "text")
    private String prezime;

    @Column(nullable = false,columnDefinition = "text")
    private String email;

    @Column(nullable = false,columnDefinition = "text")
    private String lozinka;

    @OneToMany(mappedBy = "gost",cascade = CascadeType.REMOVE)
    private List<Rezervacija> rezervacija;

    public Gost() {
        super();
    }

    public Gost(long id,String ime,String prezime,String email,String lozinka,List<Rezervacija> rezervacija){
        super();
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.rezervacija = rezervacija;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public List<Rezervacija> getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(List<Rezervacija> rezervacija) {
        this.rezervacija = rezervacija;
    }
}
