package com.marvel.MarvelAPI.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;

import java.util.List;
import java.util.Set;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class Comic {


    private Long id;
    private int available;
    private int returned;
    private String collectionURI;
    @ElementCollection
    private List<Item> items;



}
