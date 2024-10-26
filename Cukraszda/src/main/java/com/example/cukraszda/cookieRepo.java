package com.example.cukraszda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface cookieRepo extends JpaRepository<cookies, Integer> {
    @Query("SELECT new com.example.cukraszda.CookieDTO(c.id, c.name, c.type, c.awarded, p.price, p.unit, n.type_free) " +
            "FROM cookies c " +
            "LEFT JOIN prices p ON c.id = p.cookie.id " +
            "LEFT JOIN nutrients n ON c.id=n.cookie.id")
    List<CookieDTO> findAllCookiesWithDetails();


    @Query("SELECT new com.example.cukraszda.CookieDTO(c.id, c.name, c.type, c.awarded, p.price, p.unit, n.type_free) " +
            "FROM cookies c " +
            "LEFT JOIN prices p ON c.id = p.cookie.id " +
            "LEFT JOIN nutrients n ON c.id=n.cookie.id " +
            "WHERE c.id = :id")
    CookieDTO findById(@Param("id") int id);


    @Query("SELECT new com.example.cukraszda.CookieDTO(c.id, c.name, c.type, c.awarded, p.price, p.unit, n.type_free) " +
            "FROM cookies c " +
            "LEFT JOIN prices p ON c.id = p.cookie.id " +
            "LEFT JOIN nutrients n ON c.id=n.cookie.id " +
            "WHERE c.id = :id")
    List<CookieDTO> findVariationsById(@Param("id") int id);


}
