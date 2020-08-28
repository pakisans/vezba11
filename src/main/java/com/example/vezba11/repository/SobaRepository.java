package com.example.vezba11.repository;

import com.example.vezba11.model.Soba;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobaRepository extends CrudRepository<Soba,Long> {
}
