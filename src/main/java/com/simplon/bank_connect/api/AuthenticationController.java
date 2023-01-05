package com.simplon.bank_connect.api;

import com.simplon.bank_connect.config.JwtUtil;
import com.simplon.bank_connect.dto.AuthenticationRequest;
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
    public ResponseEntity<String> ClientAuthenticate(@RequestBody AuthenticationRequest request) {
        System.out.println(request.getPassword());
        System.out.println( request.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail()+"-CLIENT" ,request.getPassword().trim())
        );
        System.out.println("CLIENT AUTH");
        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail()+"-CLIENT");

        if (user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(400).body("error occurred");
    }

    @PostMapping("/agent")
    public ResponseEntity<String> AgentAuthenticate(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail()+"-ADMIN", request.getPassword().trim())
        );

        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail()+"-ADMIN");

        if (user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(400).body("error occurred");
    }
}
