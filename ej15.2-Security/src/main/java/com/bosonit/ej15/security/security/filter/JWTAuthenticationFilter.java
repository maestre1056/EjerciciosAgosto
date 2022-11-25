package com.bosonit.ej15.security.security.filter;

import com.bosonit.ej15.security.security.AuthCredentials;
import com.bosonit.ej15.security.security.TokenUtils;
import com.bosonit.ej15.security.security.UserDetailsImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials= new AuthCredentials();

        try{
            authCredentials=new ObjectMapper().readValue(request.getReader(),AuthCredentials.class);
        }catch (IOException e){

        }
        UsernamePasswordAuthenticationToken usernamePAT= new UsernamePasswordAuthenticationToken(
                authCredentials.getUsername(),
                authCredentials.getPassword(),
                authCredentials.getRoles()
        );


        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getUsername(),authResult);
        response.addHeader("Authorization","Bearer "+ token);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
