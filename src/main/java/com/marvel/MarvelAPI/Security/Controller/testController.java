package com.marvel.MarvelAPI.Security.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")

public class testController {



    @GetMapping("/hola")
    public String hola(){
        return "Hola mundo";
    }

    @GetMapping("/hola-secured")

    public String holaSecured(){
        return "Hola mundo Secured";
    }


    @GetMapping("/admin_only")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from admin only url");
    }

}
