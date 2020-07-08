package com.jsparic.beerchallenge.services;

import com.jsparic.beerchallenge.dtos.PunkapiBeer;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PukapiRestClient {

    public PunkapiBeer random() {
        RestTemplate restTemplate = new RestTemplate();
        List<PunkapiBeer> punkapiBeers = Arrays.stream(restTemplate.getForObject("https://api.punkapi.com/v2/beers/random", PunkapiBeer[].class)).collect(Collectors.toList());
        return punkapiBeers.get(0);
    }

    public List<PunkapiBeer> beersById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.punkapi.com/v2/beers/" + id;
        return Arrays.stream(restTemplate.getForObject(url, PunkapiBeer[].class)).collect(Collectors.toList());
    }

    public PunkapiBeer byId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.punkapi.com/v2/beers/" + id;
        List<PunkapiBeer> punkapiBeers = Arrays.stream(restTemplate.getForObject(url, PunkapiBeer[].class)).collect(Collectors.toList());
        return punkapiBeers.get(0);
    }


}
