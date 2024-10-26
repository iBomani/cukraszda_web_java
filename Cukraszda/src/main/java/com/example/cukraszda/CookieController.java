package com.example.cukraszda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/menu/{id}")
    public ResponseEntity<List<CookieDTO>> getCookie(@PathVariable int id) {
        List<CookieDTO> cookies = cookieService.getCookieVariations(id);
        if (cookies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cookies);

    }

    @PostMapping("/menu")
    public cookies addCookie(@RequestBody CookieDTO cookieDTO) {
        return cookieService.addCookie(cookieDTO);

    }

    @DeleteMapping("/menu/{id}")
    public void deleteCookie(@PathVariable int id) {
        cookieService.deleteCookie(id);
    }

    @PutMapping("/menu/{id}")
    public CookieDTO updateCookie(@PathVariable int id, @RequestBody CookieDTO cookieDTO) {
        return cookieService.updateCookie(id, cookieDTO);
    }

}
