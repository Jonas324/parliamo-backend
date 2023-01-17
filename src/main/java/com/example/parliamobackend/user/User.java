package com.example.parliamobackend.user;


import com.example.parliamobackend.Conversations.Conversation;
import com.example.parliamobackend.message.Message;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration

@Entity
@Table(name="Users")
public class User<Conversation> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_Id", nullable = false)
    private Long userId;

    @Column
    private String name;


    @Column
    //@OneToMany(mappedBy = "Users")
    @ManyToMany
    private List<Conversation> conversations = new ArrayList<>();


    public User(String name, List<Conversation> conversations ) {
        this.name = name;
        this.conversations = conversations;
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

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
}


