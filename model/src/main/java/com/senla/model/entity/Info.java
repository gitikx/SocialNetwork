package com.senla.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "info")

public class Info implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "birthday")
    @Temporal(value = TemporalType.DATE)
    private Date birthday;
    @Basic
    @Column(name = "about")
    private String about;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "users_id")
    private User user;

    public Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", about='" + about + '\'' +
                ", user=" + user +
                '}';
    }
}
