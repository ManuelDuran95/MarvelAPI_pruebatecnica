package com.marvel.MarvelAPI.Controller;

import com.marvel.MarvelAPI.audit.AuditUserMov;

import com.marvel.MarvelAPI.service.DataMarvelService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/marveldata")
public class DataController {
    private final DataMarvelService service;
    private final AuditUserMov auditUser;

    public DataController(DataMarvelService service, AuditUserMov auditUser) {
        this.service = service;
        this.auditUser = auditUser;
    }

    @GetMapping("/getbyname/{nombre}")
    public ResponseEntity<Object> getByNombre(@PathVariable("nombre") String nombre, @RequestHeader("Authorization") String token ) throws Exception{
        try {
            auditUser.guardar(token,"Buscar por nombre de personaje");


            return new ResponseEntity<>(service.getByName(nombre), HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));

        }

    }

    @GetMapping("/getbycomic/{comic}")
    public ResponseEntity<Object> getByComic(@PathVariable("comic") String comic,@RequestHeader("Authorization") String token) {
        try {
            auditUser.guardar(token,"Buscar por nombre de comic");
            return new ResponseEntity<>(service.getAllByComic(comic), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }


    }
    @GetMapping("/getbyserie/{serie}")
    public ResponseEntity<Object> getBySerie(@PathVariable("serie") String serie,@RequestHeader("Authorization") String token) {
        try {
            auditUser.guardar(token,"Buscar por nombre de serie");
            return new ResponseEntity<>(service.getAllBySerie(serie), HttpStatus.OK);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
