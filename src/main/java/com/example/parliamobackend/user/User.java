package com.example.parliamobackend.user;


import com.example.parliamobackend.message.Message;
import jakarta.persistence.*;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration

@Entity
@Table(name="Users")
public class User<Conversation> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_Id", nullable = false)
    private Long userId;

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="conversations",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private Set<Message> conversations = new HashSet<>();

    public User(Set<Message> conversations) {
        this.conversations = conversations;
    }

    public Set<Message> getConversations() {
        return conversations;
    }

    public void setConversations(Set<Message> conversations) {
        this.conversations = conversations;
    }

    //    public Set<Message> getConversations(Message message) {
//    }
}


