package com.marvel.MarvelAPI.repository;

import com.marvel.MarvelAPI.model.AuditUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditUserRepository extends JpaRepository<AuditUser,Integer> {


    public List<AuditUser> findAllById(Integer id);
}
