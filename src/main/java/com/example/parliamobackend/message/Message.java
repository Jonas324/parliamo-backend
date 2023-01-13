package com.example.parliamobackend.message;


import com.example.parliamobackend.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Messages")
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long senderId;
    private Long receiverId;
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



/*
    @ManyToMany(mappedBy = "conversations")
    private Set<User> messageSet = new HashSet<>();
    public Message(String content, LocalDateTime posted) {
        this.content = content;
        this.posted = posted;
    }
*/

/*
* [
*   {
*       "senderId": 1,
*       "recieverId": 2,
*       "message": "How are you?"
*   }
*   {
*       "senderId": 2,
*       "recieverId": 1,
*       "message": "Fine, you?"
*   }
* ]
*/

