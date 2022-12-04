package ru.kata.spring.boot_security.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/api")
    public String adminPage() {
        return "admin";
    }
}