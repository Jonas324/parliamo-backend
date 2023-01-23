package com.example.parliamobackend.message;


import com.example.parliamobackend.user.User;
import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Messages")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "senderId")
    private Long senderId;

    @Column(name = "receiverId")
    private Long receiverId;
    @Column(name = "content")
    private String content;

    private LocalDateTime posted = LocalDateTime.now();

    public Message(Long senderId,
                   Long receiverId,
                   String content,
                   LocalDateTime posted) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
        this.posted = posted;
    }

    public Message (){}

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPosted() {
        return posted;
    }

    public void setPosted(LocalDateTime posted) {
        this.posted = posted;
    }

    @Override
    public String toString() {
        return "Message{" +
                "posted=" + posted +
                '}';
    }


}


