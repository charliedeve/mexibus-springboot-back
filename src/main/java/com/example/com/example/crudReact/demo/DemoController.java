package com.example.com.example.crudReact.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value = "demo")
    public String saludarJwt(){
        return "Hi since JWT";
    }
}
