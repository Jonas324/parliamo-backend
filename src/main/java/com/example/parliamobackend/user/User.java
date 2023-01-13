package com.example.parliamobackend.user;


import jakarta.persistence.*;
import org.springframework.context.annotation.Configuration;

@Configuration

@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    public User(String name) {
        this.name = name;
    }


    public User() {
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*@ManyToMany
    @JoinTable(name="conversations",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "message_id")
    )
    private Set<Conversation> conversations = new HashSet<>();*/

