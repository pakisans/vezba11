package com.example.vezba11.service;

import com.example.vezba11.model.Rezervacija;
import com.example.vezba11.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RezervacijaService {

    @Autowired
    RezervacijaRepository repo;

    public Iterable<Rezervacija> dobaviSve(){
        return repo.findAll();
    }

    public Rezervacija dobaviPoId(Long id){
        return repo.findById(id).orElse(null);
    }

    public void save(Rezervacija obj){
        repo.save(obj);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
