package com.marvel.MarvelAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.marvel.MarvelAPI.model.Data1;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponseDTO {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private Data1 data;


}