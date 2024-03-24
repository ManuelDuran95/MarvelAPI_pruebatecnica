package com.marvel.MarvelAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List<Url> urls;
    private Comic comics;
    private Item series;
}
