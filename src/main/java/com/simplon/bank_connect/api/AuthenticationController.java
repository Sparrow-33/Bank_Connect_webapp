package com.simplon.bank_connect.api;

import com.simplon.bank_connect.config.JwtUtil;
import com.simplon.bank_connect.dto.AuthenticationRequest;
import com.simplon.bank_connect.dto.Token;
import com.simplon.bank_connect.exceptions.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @PostMapping("/client")
    public ResponseEntity<Token> ClientAuthenticate(@RequestBody AuthenticationRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail().trim()+"-CLIENT" ,
                request.getPassword().trim()));
        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail()+"-CLIENT");

        if (user == null) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(user, "-CLIENT"));
        return ResponseEntity.ok(token);
    }

    @PostMapping("/agent")
    public ResponseEntity<Token> AgentAuthenticate(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail().trim()+"-ADMIN",
                                request.getPassword().trim().trim())
        );

        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail()+"-ADMIN");

        if (user == null) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(user, "-CLIENT"));
        return ResponseEntity.ok(token);
    }
}
