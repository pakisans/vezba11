package com.example.vezba11.model;

public class AuthResposne {
    private final String jwt;

    public AuthResposne(String jwt){
        super();
        this.jwt = jwt;
    }

    public String getJwt(){
        return jwt;
    }
}
