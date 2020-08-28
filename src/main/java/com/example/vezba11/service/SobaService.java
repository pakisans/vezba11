package com.example.vezba11.service;

import com.example.vezba11.model.Soba;
import com.example.vezba11.repository.SobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SobaService {
    @Autowired
    SobaRepository repo;

    public Iterable<Soba> dobaviSve(){
        return repo.findAll();
    }

    public Soba dobaviPoId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Soba obj) {
        repo.save(obj);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
