package com.marvel.MarvelAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data1 {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private Result results;

}