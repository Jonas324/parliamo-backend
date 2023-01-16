package com.example.parliamobackend.message;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value =
            "SELECT m FROM Message m WHERE m.receiverId = ?1 AND m.senderId = ?2"
    )
    Message findByReceiverIdAndSenderId(Long receiverId, Long senderId);

    @Query("SELECT s FROM Message s WHERE s.receiverId = ?1")
    Optional<Message> findAllByReceiverIdAndSenderId(Long message);

}
