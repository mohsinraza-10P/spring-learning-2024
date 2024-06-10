package com.mohsin.restful_web_services.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohsin.restful_web_services.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Description must not be blank.")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
