package com.senla.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "public_messages", schema = "mydb")
public class PublicMessage {
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "date")
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "users_id")
    private User sender;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "forum_id")
    private Forum forum;

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
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

        PublicMessage that = (PublicMessage) o;

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
}
