package com.example.vezba11.controller;

import com.example.vezba11.dto.GostDTO;
import com.example.vezba11.dto.RezervacijaDTO;
import com.example.vezba11.model.Gost;
import com.example.vezba11.model.Rezervacija;
import com.example.vezba11.security.JwtUtil;
import com.example.vezba11.service.GostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Controller
@RequestMapping(path = "/gost")
public class GostController {

    @Autowired
    GostService service;

    @Autowired
    JwtUtil jwtUtil;

    ArrayList<GostDTO> lista;

    //Dobavi sve
    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<GostDTO>> dobaviSve(){
        ModelMapper mm = new ModelMapper();

        lista = new ArrayList<GostDTO>();
        for(Gost x:service.dobaviSve()) {
            lista.add(mm.map(x, GostDTO.class));
        }

        return new ResponseEntity<ArrayList<GostDTO>>(lista, HttpStatus.OK);
    }

    //Dobavi sve
    @RequestMapping(path = "/poEmailu", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<RezervacijaDTO>> dobaviSvePoEmailu(@RequestHeader("Authorization") String header){
        ModelMapper mm = new ModelMapper();

        final String authorizationHeader = header;

        ArrayList<RezervacijaDTO>lista = new ArrayList<RezervacijaDTO>();

        for(Rezervacija x:service.dobaviPoEmail(jwtUtil.extractUsername(authorizationHeader))) {
            lista.add(mm.map(x, RezervacijaDTO.class));
        }

        return new ResponseEntity<ArrayList<RezervacijaDTO>>(lista, HttpStatus.OK);
    }


    //Dobavi po ID
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GostDTO> dobaviPoId(@PathVariable("id") Long id){
        ModelMapper mm = new ModelMapper();
        Gost existing = service.dobaviPoId(id);

        if(existing == null) {
            return new ResponseEntity<GostDTO>(HttpStatus.NOT_FOUND);
        }
        GostDTO obj = mm.map(existing, GostDTO.class);
        return new ResponseEntity<GostDTO>(obj, HttpStatus.OK);

    }

    //Dodavanje novog
    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Gost> dodajNovi(@RequestBody Gost obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Gost>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Gost>(HttpStatus.OK);
    }

    //Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Gost> izmeni(@RequestBody Gost obj) {
        Gost existing = service.dobaviPoId(obj.getId());

        if (existing == null) {
            return new ResponseEntity<Gost>(HttpStatus.NOT_FOUND);
        }

        existing.setEmail(obj.getEmail());
        existing.setLozinka(obj.getLozinka());

        service.save(existing);
        return new ResponseEntity<Gost>(HttpStatus.OK);
    }

    //Brisanje
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> brisanje(@PathVariable("id") Long id) {

        if (service.dobaviPoId(id) == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }

        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
