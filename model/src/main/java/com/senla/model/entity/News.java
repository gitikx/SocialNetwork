package com.senla.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "news")
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "text")
    private String text;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "users_id")
    private User user;

    public News() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (text != null ? !text.equals(news.text) : news.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
