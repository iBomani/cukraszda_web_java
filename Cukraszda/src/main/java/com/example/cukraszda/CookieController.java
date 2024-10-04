package com.example.cukraszda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CookieController {
    @Autowired
    private CookieService cookieService;

    @GetMapping("/menu")
    public List<CookieDTO> getCookies() {
        return cookieService.getAllCookies();
    }

}
