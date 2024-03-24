package com.marvel.MarvelAPI.service;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;


@Service
public class DataMarvelService {

    private final  RestTemplate restTemplate;
    private final String MARVEL_URL="https://gateway.marvel.com:443/v1/public/";
    private final String API_KEY="&ts=1&apikey=60498638027ff9faeac728f7c726a0a6&hash=600443b279b902813973889e0a06226c";

    public DataMarvelService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Object getByName(String nombre) {
        HttpHeaders headers = new HttpHeaders();
        Object response = restTemplate.exchange(MARVEL_URL+"characters?name="+nombre+API_KEY,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Object.class
        );


        return response;

    }

    public Object getAllByComic(String comic) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> response = restTemplate.exchange(MARVEL_URL+"characters?comics="+comic+API_KEY,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Object.class
        );
        return response.getBody();

    }
    public Object getAllBySerie(String serie) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> response = restTemplate.exchange(MARVEL_URL+"characters?series="+serie+API_KEY,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Object.class
        );
        return response.getBody();

    }
    public Object getAllComicsByName(String nombrePersonaje) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<Object> response = restTemplate.exchange(MARVEL_URL+"comics?characters="+nombrePersonaje+API_KEY,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Object.class
        );
        return response.getBody();

    }





}
