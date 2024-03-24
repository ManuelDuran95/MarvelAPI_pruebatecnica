package com.marvel.MarvelAPI.service;

import com.marvel.MarvelAPI.Security.Persistence.Entity.UserEntity;
import com.marvel.MarvelAPI.Security.Service.AuthenticationService;
import com.marvel.MarvelAPI.model.AuditUser;
import com.marvel.MarvelAPI.repository.AuditUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {

    @Autowired
    private AuditUserRepository auditUserRepository;



    public void guardarBusqueda(AuditUser auditUser){
        auditUserRepository.save(auditUser);

    }

    public List<AuditUser> getAuditoria(){
        return auditUserRepository.findAll();
    }

    public List<AuditUser> getAuditByUser(String username) {
        return  auditUserRepository.findByUsuario(username);
    }

}
