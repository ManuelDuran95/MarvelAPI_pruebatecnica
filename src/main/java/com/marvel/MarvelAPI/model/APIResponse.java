package com.marvel.MarvelAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private Data1 data;
}
