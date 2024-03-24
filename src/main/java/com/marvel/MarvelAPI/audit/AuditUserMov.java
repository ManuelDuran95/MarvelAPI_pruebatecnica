package com.marvel.MarvelAPI.audit;

import com.marvel.MarvelAPI.Security.Service.JwtService;
import com.marvel.MarvelAPI.model.AuditUser;
import com.marvel.MarvelAPI.service.AuditService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class AuditUserMov {

    private final AuditService auditService;
    private final JwtService jwtService;

    public AuditUserMov(AuditService auditService, JwtService jwtService) {
        this.auditService = auditService;
        this.jwtService = jwtService;
    }


    public void guardar(String token,String busqueda){
        String tok=token.substring(7);
        String username=jwtService.extractUsername(tok);
        AuditUser usuario=new AuditUser();
        usuario.setUsuario(username);
        usuario.setBusqueda(busqueda);
        auditService.guardarBusqueda(usuario);



    }



}
