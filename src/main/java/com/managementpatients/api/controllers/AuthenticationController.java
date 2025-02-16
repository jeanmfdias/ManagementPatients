package com.managementpatients.api.controllers;

import com.managementpatients.api.infra.security.AuthTokenDto;
import com.managementpatients.api.domains.users.DataLoginDto;
import com.managementpatients.api.infra.security.TokenService;
import com.managementpatients.api.domains.users.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataLoginDto dataLoginDto) {
        var token = new UsernamePasswordAuthenticationToken(dataLoginDto.email(), dataLoginDto.password());
        var authentication = manager.authenticate(token);
        var authTokenDto = new AuthTokenDto(tokenService.tokenGenerate((User) authentication.getPrincipal()));
        return ResponseEntity.ok(authTokenDto);
    }

}
