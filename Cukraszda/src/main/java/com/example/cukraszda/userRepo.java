package com.example.cukraszda;
import org.springframework.data.repository.CrudRepository;
public interface userRepo extends CrudRepository<users, Integer>{
    users findByUsername(String username);
    users findById(int id);
}
