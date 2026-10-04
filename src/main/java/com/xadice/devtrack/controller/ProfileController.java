package com.xadice.devtrack.controller;

import com.xadice.devtrack.dto.response.UserResponse;
import com.xadice.devtrack.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @GetMapping
    public ResponseEntity<UserResponse> getProfile(
            Authentication authentication
    ) {

        User user = (User) authentication.getPrincipal();

        UserResponse response = new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }
}