package com.example.parliamobackend.message;


import com.example.parliamobackend.user.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    private String content;

    private LocalDateTime posted;







    public Message (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}



/*
    @ManyToMany(mappedBy = "conversations")
    private Set<User> messageSet = new HashSet<>();
    public Message(String content, LocalDateTime posted) {
        this.content = content;
        this.posted = posted;
    }
*/
