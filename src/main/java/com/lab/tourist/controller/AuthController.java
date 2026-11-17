package com.lab.tourist.controller;

import com.lab.tourist.dto.TokenRequest;
import com.lab.tourist.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody TokenRequest request) {
        if ("admin".equals(request.getUsername())
                && "admin123".equals(request.getPassword())) {
            return ResponseEntity.ok(Map.of(
                    "token", jwtService.generateToken(request.getUsername()),
                    "tokenType", "Bearer",
                    "expiresIn", "1 hour"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Invalid username or password"));
    }
}
