package com.example.cukraszda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cookieRepo extends JpaRepository<cookies, Integer> {
    @Query("SELECT new com.example.cukraszda.CookieDTO(c.name, c.type, c.awarded, p.price, p.unit, n.type_free) " +
            "FROM cookies c " +
            "LEFT JOIN prices p ON c.id = p.cookie.id " +
            "LEFT JOIN nutrients n ON c.id=n.cookie.id")
    List<CookieDTO> findAllCookiesWithDetails();

}
