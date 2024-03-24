package com.marvel.MarvelAPI.service;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DataMarvelService {

    private final  RestTemplate restTemplate;

    public DataMarvelService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Object getById(Long id) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> response = restTemplate.exchange(
                "https://gateway.marvel.com:443/v1/public/characters?name=sabra&ts=1&apikey=60498638027ff9faeac728f7c726a0a6&hash=600443b279b902813973889e0a06226c" ,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Object.class
        );
        System.out.println(response.getBody());

        return response.getBody();

    }
}
