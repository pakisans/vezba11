package com.example.vezba11.security;

import com.example.vezba11.service.GostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private GostService service;

    @Autowired
    private JwtUtil util;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        //ovaj deo
        String email = null;
        String jwt = null;

        //ovaj deo
        if(authorizationHeader != null) {
            jwt = authorizationHeader;
            email = util.extractUsername(jwt);
        }

        //ovaj deo
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails ud = this.service.loadUserByUsername(email);

            if(util.validateToken(jwt, ud)) {
                UsernamePasswordAuthenticationToken uapToken = new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities());
                uapToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(uapToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
