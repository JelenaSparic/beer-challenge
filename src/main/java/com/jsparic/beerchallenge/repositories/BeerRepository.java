package com.jsparic.beerchallenge.repositories;

import com.jsparic.beerchallenge.entities.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long> {
    Beer findById(long id);
    List<Beer> findAll();
    boolean existsByName(String name);
}
