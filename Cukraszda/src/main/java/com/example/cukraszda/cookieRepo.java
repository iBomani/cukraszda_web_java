package com.example.cukraszda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cookieRepo extends JpaRepository<cookies, Integer> {
}
