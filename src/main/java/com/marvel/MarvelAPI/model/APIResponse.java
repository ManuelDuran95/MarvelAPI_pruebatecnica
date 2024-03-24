package com.marvel.MarvelAPI.model;

import lombok.Data;

import java.util.List;


@Data
public class APIResponse {
    private List<AuditUser> busquedas;
    private String msg;


}
