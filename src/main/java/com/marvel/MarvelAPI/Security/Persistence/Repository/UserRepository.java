package com.marvel.MarvelAPI.Security.Persistence.Repository;

import com.marvel.MarvelAPI.Security.Persistence.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {


    Optional<UserEntity> findByUsername(String username);
}
