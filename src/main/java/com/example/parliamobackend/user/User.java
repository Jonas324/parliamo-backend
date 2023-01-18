package com.example.parliamobackend.user;



import jakarta.persistence.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Entity
@Table(name="Users")
public class User<Conversation> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public Long getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


