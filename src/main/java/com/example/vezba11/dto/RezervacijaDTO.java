package com.example.vezba11.dto;

import java.time.LocalDateTime;

public class RezervacijaDTO {
    Long id;
    LocalDateTime odKad;
    LocalDateTime doKac;
    SobaDTO soba;
    GostDTO gost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOdKad() {
        return odKad;
    }

    public void setOdKad(LocalDateTime odKad) {
        this.odKad = odKad;
    }

    public LocalDateTime getDoKac() {
        return doKac;
    }

    public void setDoKac(LocalDateTime doKac) {
        this.doKac = doKac;
    }

    public SobaDTO getSoba() {
        return soba;
    }

    public void setSoba(SobaDTO soba) {
        this.soba = soba;
    }

    public GostDTO getGost() {
        return gost;
    }

    public void setGost(GostDTO gost) {
        this.gost = gost;
    }
}
