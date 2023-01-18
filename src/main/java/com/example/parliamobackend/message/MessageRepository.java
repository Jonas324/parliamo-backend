package com.example.parliamobackend.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.senderId = ?1 and m.receiverId = ?2")
    List<Message> findAllByReceiverIdIdAndSenderId(Long receiverId, Long senderId);

    @Query("select m from Message m where m.senderId = ?1 and m.receiverId = ?2")
    List<Message> findAllBySenderIdAndReceiverId(Long senderId, Long receiverId);

}
