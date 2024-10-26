package com.example.cukraszda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookieService {
    @Autowired
    private com.example.cukraszda.cookieRepo cookieRepo;

    public List<CookieDTO> getAllCookies() {
        return cookieRepo.findAllCookiesWithDetails();
    }


    public CookieDTO getCookie(int id) {
        return cookieRepo.findById(id);
    }

    public cookies addCookie(CookieDTO cookieDTO) {
        cookies cookies = new cookies();
        cookies.setName(cookieDTO.getName());
        cookies.setType(cookieDTO.getType());
        cookies.setAwarded(cookieDTO.getAwarded());

        prices prices = new prices();
        prices.setPrice(cookieDTO.getPrice());
        prices.setUnit(cookieDTO.getUnit());
        prices.setCookie(cookies);

        nutrients nutrients = new nutrients();
        nutrients.setType_free(cookieDTO.getType_free());
        nutrients.setCookie(cookies);

        cookies.setPrice(prices);
        cookies.setNutrient(nutrients);

        return cookieRepo.save(cookies);
    }

    public void deleteCookie(int id) {
        cookieRepo.deleteById(id);
    }

    public CookieDTO updateCookie(int id, CookieDTO cookieDTO) {
        CookieDTO cookie = cookieRepo.findById(id);

        if (cookie != null) {
            cookie.setName(cookieDTO.getName());
            cookie.setType(cookieDTO.getType());
            cookie.setAwarded(cookieDTO.getAwarded());
            cookie.setPrice(cookieDTO.getPrice());
            cookie.setUnit(cookieDTO.getUnit());
            cookie.setType_free(cookieDTO.getType_free());

            cookies updatedCookie = mapToEntity(cookie);

            cookieRepo.save(updatedCookie);

            return cookie;
        } else {
            return null;
        }


    }

    private cookies mapToEntity(CookieDTO cookie) {
        cookies cookies = new cookies();
        cookies.setId(cookie.getId());
        cookies.setName(cookie.getName());
        cookies.setType(cookie.getType());
        cookies.setAwarded(cookie.getAwarded());

        prices prices = new prices();
        prices.setPrice(cookie.getPrice());
        prices.setUnit(cookie.getUnit());
        prices.setCookie(cookies);

        nutrients nutrients = new nutrients();
        nutrients.setType_free(cookie.getType_free());
        nutrients.setCookie(cookies);

        cookies.setPrice(prices);
        cookies.setNutrient(nutrients);

        return cookies;
    }


    public List<CookieDTO> getCookieVariations(int id) {
        return cookieRepo.findVariationsById(id);
    }
}
