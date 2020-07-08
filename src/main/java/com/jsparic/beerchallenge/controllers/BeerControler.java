package com.jsparic.beerchallenge.controllers;

import com.jsparic.beerchallenge.dtos.BeerDTO;
import com.jsparic.beerchallenge.entities.Beer;
import com.jsparic.beerchallenge.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/beers")
public class BeerControler {
    @Autowired
    private BeerService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BeerDTO>> getAll(){
        return  new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBeer(@RequestBody Beer beer) {
        return  new ResponseEntity<>(service.addBeer(beer), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delBeer (@PathVariable(value = "id") long id){
        return new ResponseEntity<>(service.delBeer(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BeerDTO> getById(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @GetMapping(value="/refill")
    public ResponseEntity<String> refill(){
        return new ResponseEntity<>(service.refill(), HttpStatus.OK);
    }
}
