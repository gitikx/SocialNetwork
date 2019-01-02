package com.senla.model.dao.api;

import com.senla.model.entity.Friend;

import java.util.List;

public interface IFriendDao {
    List<Friend> getByUserId(int id);

    Boolean update(Friend entity);

    Boolean delete(Friend friend);

    Integer create(Friend entity);

    boolean checkFriend(Friend friend);

    List<Friend> getRequestsByUserId(int id);

}
