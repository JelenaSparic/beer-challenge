package com.jsparic.beerchallenge.services;

import com.jsparic.beerchallenge.dtos.BeerDTO;
import com.jsparic.beerchallenge.dtos.PunkapiBeer;
import com.jsparic.beerchallenge.entities.Beer;
import com.jsparic.beerchallenge.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeerService implements BeerServiceI {
    public static final int BEER_DB_LIMIT = 10;

    @Autowired
    private BeerRepository repository;

    @Override
    public BeerDTO getById(long id) {
        if(repository.existsById(id)){
            Beer beer = repository.findById(id);
            return new BeerDTO(beer.getId(), beer.getName(), beer.getDescription(), beer.getMash_temp());
        } else throw new EntityNotFoundException("Beer id " + id + " not found.");
    }

    @Override
    public List<BeerDTO> getAll() {
        List<BeerDTO> beerDTOS = new ArrayList<>();
        repository.findAll().forEach(beer -> {
            beerDTOS.add(new BeerDTO(beer.getId(), beer.getName(), beer.getDescription(), beer.getMash_temp()));
        });
        if(beerDTOS.size() > 0){
            return beerDTOS;
        } else throw new EntityNotFoundException("No beer found in database.");

    }

    @Override
    public String refill(){
        if(repository.count() < BEER_DB_LIMIT){
            PukapiRestClient pukapiRestClient = new PukapiRestClient();
            while(repository.count() < BEER_DB_LIMIT){
                PunkapiBeer punkapiBeer = pukapiRestClient.random();
                Beer beer = new Beer();
                beer.setName(punkapiBeer.getName());
                beer.setDescription(punkapiBeer.getDescription());
                beer.setMash_temp(punkapiBeer.getTemps());
                if (!repository.existsByName(beer.getName())){
                    repository.save(beer);
                }
            }
        }
        return "{\n" +
                "  \"_embedded\" : {\n" +
                "    \"beers\" : [" + repository.count() + "]\n" +
                "  }\n" +
                "}";
    }

    @Override
    public String addBeer (Beer beer){
        if (!repository.existsByName(beer.getName())){
            repository.save(beer);
            return beer.toString();
        } else return "Duplicate beer name. Beer was not saved.";

    }

    @Override
    public String delBeer(long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Beer was deleted";
        } else throw new EntityNotFoundException("Beer id " + id + " not found.");
    }

}
