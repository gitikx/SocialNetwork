package com.senla.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "forums")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "info")
    private String info;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_id")
    private User admin;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "users_forums",
            joinColumns = {@JoinColumn(name = "forums_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")})
    private List<User> users;
    @OneToMany(mappedBy = "forum")
    private List<PublicMessage> messages;

    public Forum() {
        users = new ArrayList<>();
    }


    public List<PublicMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PublicMessage> messages) {
        this.messages = messages;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forum forums = (Forum) o;

        if (id != forums.id) return false;
        if (info != null ? !info.equals(forums.info) : forums.info != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }
}
