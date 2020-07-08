package com.jsparic.beerchallenge.services;

import com.jsparic.beerchallenge.dtos.BeerDTO;
import com.jsparic.beerchallenge.entities.Beer;

import java.util.List;

public interface BeerServiceI {
    public BeerDTO getById(long id);
    public List<BeerDTO> getAll();
    public String refill();
    public String addBeer(Beer beer);
    public String delBeer(long id);
}
