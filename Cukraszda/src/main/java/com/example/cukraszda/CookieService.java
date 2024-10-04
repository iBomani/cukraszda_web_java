package com.example.cukraszda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookieService {
    @Autowired
    private com.example.cukraszda.cookieRepo cookieRepo;

    public List<CookieDTO> getAllCookies() {
        return cookieRepo.findAllCookiesWithDetails();
    }
}
