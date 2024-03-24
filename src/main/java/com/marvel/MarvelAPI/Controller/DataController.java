package com.marvel.MarvelAPI.Controller;

import com.marvel.MarvelAPI.audit.AuditUserMov;
import com.marvel.MarvelAPI.service.AuditService;
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

            auditUser.guardar(token,"Buscar por nombre");

            return new ResponseEntity<>(service.getByName(nombre), HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));

        }

    }

    @GetMapping("/getbycomic/{comic}")
    public ResponseEntity<Object> getByComic(@PathVariable("comic") String comic) throws Exception{
        try {
            return new ResponseEntity<>(service.getAllByComic(comic), HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));

        }


    }
    @GetMapping("/getbycomic/{serie}")
    public ResponseEntity<Object> getBySerie(@PathVariable("serie") String serie) throws Exception{
        try {
            return new ResponseEntity<>(service.getAllBySerie(serie), HttpStatus.OK);
        }catch (Exception e){
            throw new Exception(String.valueOf(HttpStatus.BAD_REQUEST));

        }


    }

}
