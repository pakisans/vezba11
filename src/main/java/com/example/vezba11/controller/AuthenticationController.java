package com.example.vezba11.controller;

import com.example.vezba11.model.AuthRequest;
import com.example.vezba11.model.AuthResposne;
import com.example.vezba11.security.JwtUtil;
import com.example.vezba11.service.GostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil util;

    @Autowired
    GostService serviceAuth;


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) throws Exception{

        //ovaj deo
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getLozinka()));
        }
        catch(BadCredentialsException e) {
            throw new Exception("Pogresni podaci", e);
        }

        //ovaj deo
        final UserDetails userDetails = serviceAuth.loadUserByUsername(authRequest.getEmail());
        final String jwt = util.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResposne(jwt));
    }
}
