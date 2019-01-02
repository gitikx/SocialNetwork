package com.senla.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "blocked")
    private byte blocked;
    @Basic
    @Column(name = "login")
    private String login;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Info info;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "users_private_messages",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "private_id")})
    private List<PrivateMessage> messages;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "users_forums",
            joinColumns = {@JoinColumn(name = "users_id")},
            inverseJoinColumns = {@JoinColumn(name = "forums_id")})
    private List<Forum> forums;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<News> news;

    public User() {
        messages = new ArrayList<>();
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Forum> getForums() {
        return forums;
    }

    public void setForums(List<Forum> forums) {
        this.forums = forums;
    }

    public List<PrivateMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PrivateMessage> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getBlocked() {
        return blocked;
    }

    public void setBlocked(byte blocked) {
        this.blocked = blocked;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", blocked=" + blocked +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
