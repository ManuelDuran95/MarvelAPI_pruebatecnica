package com.marvel.MarvelAPI.Security.Controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class testController {



    @GetMapping("/hola")
    public String hola(){
        return "Hola mundo";
    }

    @GetMapping("/hola-secured")
    @PreAuthorize("hasAuthority('CREATE')")
    public String holaSecured(){
        return "Hola mundo Secured";
    }


    @GetMapping("/hola-secured2")
    @PreAuthorize("hasRole('ADMIN')")
    public String holaSecured2(){
        return "Hola mundo Secured2";
    }

    @GetMapping("/get")
    public String helloGet(){
        return "Hello World - GET";
    }

    @PostMapping("/post")
    public String helloPost(){
        return "Hello World - POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello World - PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello World - DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch(){
        return "Hello World - PATCH";
    }

}
