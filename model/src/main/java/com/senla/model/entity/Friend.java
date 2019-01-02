package com.senla.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "accept")
    private byte accept;
    @Basic
    @Column(name = "deleted")
    private byte deleted;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "friend_1_id")
    private User friendOne;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "friend_2_id")
    private User friendTwo;

    public Friend() {
        friendOne = new User();
        friendTwo = new User();
    }

    public Friend(int friendId, int userId) {
        friendOne = new User();
        friendOne.setId(userId);
        friendTwo = new User();
        friendTwo.setId(friendId);
    }

    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    public User getFriendOne() {
        return friendOne;
    }

    public void setFriendOne(User friendOne) {
        this.friendOne = friendOne;
    }

    public User getFriendTwo() {
        return friendTwo;
    }

    public void setFriendTwo(User friendTwo) {
        this.friendTwo = friendTwo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getAccept() {
        return accept;
    }

    public void setAccept(byte accept) {
        this.accept = accept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friends = (Friend) o;

        if (id != friends.id) return false;
        if (accept != friends.accept) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) accept;
        return result;
    }
}
