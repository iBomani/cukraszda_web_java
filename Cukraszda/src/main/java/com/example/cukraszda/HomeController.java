package com.example.cukraszda;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/admin")
    public String admin() {
         return "admin";
    }


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new users());
        return "registration";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
