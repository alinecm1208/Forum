package com.aline.forum.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/teste")
@RestController
public class TestController {

    @GetMapping
    public ResponseEntity<String> test(HttpServletRequest request) {
        System.out.println(request.getUserPrincipal().getName());
        return ResponseEntity.ok().body("entrei");
    }
}
