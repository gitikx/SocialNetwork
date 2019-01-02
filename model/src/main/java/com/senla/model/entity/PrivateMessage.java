package com.senla.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "private_messages", schema = "mydb")
public class PrivateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "text")
    private String text;
    @Temporal(value = TemporalType.DATE)
    @Column(name = "date")
    private Date date;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sender_id")
    private User sender;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "recipient_id")
    private User recipient;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "users_private_messages",
            joinColumns = {@JoinColumn(name = "private_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")})
    private List<User> users;

    public PrivateMessage() {
        sender = new User();
        recipient = new User();
        users = new ArrayList<>();
    }


    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }


    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivateMessage that = (PrivateMessage) o;

        if (id != that.id) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PrivateMessage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", sender=" + sender.getLogin() +
                ", recipient=" + recipient.getLogin() +
                '}';
    }
}
