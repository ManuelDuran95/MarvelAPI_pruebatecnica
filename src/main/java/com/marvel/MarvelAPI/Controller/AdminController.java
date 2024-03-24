package com.marvel.MarvelAPI.Controller;

import com.marvel.MarvelAPI.model.APIResponse;
import com.marvel.MarvelAPI.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/data")
public class AdminController {
    private final AuditService auditService;

    public AdminController(AuditService auditService) {
        this.auditService = auditService;
    }


    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBusquedasUSuarios(){
        auditService.getAuditoria();
        APIResponse res=new APIResponse();
        res.setBusquedas(auditService.getAuditoria());
        res.setMsg("Auditorias");


        return new ResponseEntity<>(res, HttpStatus.OK) ;

    }
    @GetMapping("/getbyid/{username}")
    public ResponseEntity<APIResponse> getAllBusquedasById(@PathVariable("username") String username){
        auditService.getAuditoria();
        APIResponse res=new APIResponse();
        res.setBusquedas(auditService.getAuditByUser(username));
        res.setMsg("Auditorias de un usuario");


        return new ResponseEntity<>(res, HttpStatus.OK) ;

    }
}
