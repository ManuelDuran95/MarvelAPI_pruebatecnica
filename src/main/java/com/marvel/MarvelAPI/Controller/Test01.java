package com.marvel.MarvelAPI.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@PreAuthorize("denyAll()")
public class Test01 {

    @GetMapping("/hola2")
    @PreAuthorize("hasRole('ADMIN')")
    public String holatest01(){
        return "Hola de nuevo";
    }

}
