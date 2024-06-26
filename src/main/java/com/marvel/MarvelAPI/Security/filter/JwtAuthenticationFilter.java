package com.marvel.MarvelAPI.Security.filter;

import com.marvel.MarvelAPI.Security.Service.JwtService;
import com.marvel.MarvelAPI.Security.Service.UserDetailServiceImpl;
import com.marvel.MarvelAPI.service.AuditService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailServiceImpl userDetailService;

    private final AuditService auditService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailServiceImpl userDetailService, AuditService auditService) {
        this.jwtService = jwtService;
        this.userDetailService = userDetailService;
        this.auditService = auditService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        String autheHeader = request.getHeader("Authorization");


        if(autheHeader == null || !autheHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        String token =autheHeader.substring(7);
        String username= jwtService.extractUsername(token);

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailService.loadUserByUsername(username);
            if(jwtService.isValid(token,userDetails)){
                UsernamePasswordAuthenticationToken authToken =new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);



    }
}
