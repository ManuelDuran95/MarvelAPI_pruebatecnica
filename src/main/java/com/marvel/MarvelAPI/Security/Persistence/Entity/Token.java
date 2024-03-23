package com.marvel.MarvelAPI.Security.Persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "token")
@Setter
@Getter
public class Token {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "token")
        private String token;

        @Column(name = "is_logged_out")
        private boolean loggedOut;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserEntity user;
}
