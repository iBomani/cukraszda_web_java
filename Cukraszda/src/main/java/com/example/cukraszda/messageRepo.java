package com.example.cukraszda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface messageRepo extends JpaRepository<messages, Integer>{
    @Query("SELECT new com.example.cukraszda.MessageDTO(u.username, m.title, m.content, m.date) " +
            "FROM messages m " +
            "LEFT JOIN users u ON m.user.id = u.id ")
    List<MessageDTO> findAllMessagesWithDetails();
}
