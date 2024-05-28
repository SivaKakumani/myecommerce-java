package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String helloWorld() {
        return "<p>Welcome to authentication api of kvsp</p>";
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> signup(@RequestBody(required = false) Map<String, Object> payload, HttpServletRequest request) {
        if (payload != null && "POST".equalsIgnoreCase(request.getMethod())) {
            String username = (String) payload.get("name");
            String email = (String) payload.get("email");
            jdbcTemplate.update("INSERT INTO pygo (name, email) VALUES (?, ?)", username, email);
            System.out.println(username);
            System.out.println(email);
            return ResponseEntity.ok().body(Map.of("status", "post success"));
        } else {
            return ResponseEntity.ok().body(Map.of("status", "get success"));
        }
    }
}
