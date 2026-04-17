package com.eventmanage.auth.controller;

import com.eventmanage.auth.model.User;
import com.eventmanage.auth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@CrossOrigin(origins = "https://studenteventmgtdepl-qqjjq83ub-sthuthi2410236-9833s-projects.vercel.app")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {

        String email = credentials.get("email").trim();
        String password = credentials.get("password").trim();

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            Map<String, String> response = new HashMap<>();
            response.put("role", user.getRole());
            return response;
        }

        throw new RuntimeException("Invalid Credentials");
    }
}