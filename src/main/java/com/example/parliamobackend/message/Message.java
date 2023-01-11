package com.example.parliamobackend.message;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Message {


    private String content;

    private LocalDateTime posted;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Message(String content, LocalDateTime posted) {
        this.content = content;
        this.posted = posted;
    }

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
