package com.example.parliamobackend.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT content FROM Message WHERE senderId = ?1 AND receiverId = ?1")
    Message findMessageByReceiverId(Long senderId, Long receiverId);
}
