package com.example.vezba11.repository;

import com.example.vezba11.model.Gost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface GostRepository extends CrudRepository<Gost,Long> {
    @Query("SELECT r FROM Gost as r WHERE r.email = :email")
    public Gost dobaviPoEmail(@PathVariable("email")String email);
}
