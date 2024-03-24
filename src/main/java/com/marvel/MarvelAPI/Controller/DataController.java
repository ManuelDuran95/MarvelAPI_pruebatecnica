package com.marvel.MarvelAPI.Controller;

import com.marvel.MarvelAPI.service.DataMarvelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/marveldata")
public class DataController {
    private final DataMarvelService service;

    public DataController(DataMarvelService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){

        return new ResponseEntity(service.getById(id), HttpStatus.OK);
    }

}
