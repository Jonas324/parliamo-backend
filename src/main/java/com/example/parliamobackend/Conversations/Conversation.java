package com.example.parliamobackend.Conversations;

import com.example.parliamobackend.message.Message;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Conversations")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column
    private Long user1;
    @Column
    private Long user2;
    @Column
    @ManyToMany
    private List<Message> conversation = new ArrayList<>();


    public Conversation() {}
    public Conversation(Long user1, Long user2, List<Message> conversation) {
        this.user1 = user1;
        this.user2 = user2;
        this.conversation = conversation;
    }


    public Long getId() {
        return id;
    }


    public Long getUser1() {
        return user1;
    }

    public void setUser1(Long user1) {
        this.user1 = user1;
    }

    public Long getUser2() {
        return user2;
    }

    public void setUser2(Long user2) {
        this.user2 = user2;
    }


    public List<Message> getConversation() {
        return conversation;
    }

    public void setConversation(List<Message> conversation) {
        this.conversation = conversation;
    }

}
