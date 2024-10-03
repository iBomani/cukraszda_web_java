package com.example.cukraszda;
import org.springframework.data.repository.CrudRepository;
public interface messageRepo extends CrudRepository<messages, Integer>{
    messages findById(int id);
}
