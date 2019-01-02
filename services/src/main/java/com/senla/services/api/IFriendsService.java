package com.senla.services.api;



import com.senla.model.entity.Friend;
import com.senla.model.entity.User;

import java.util.List;

public interface IFriendsService {
    List<User> getByUserId(int id);

    List<User> getRequestsById(int id);

    void delete(Friend friend);

    boolean checkFriend(Friend friend);

    void addFriend(Friend friend);

    void acceptFriend(Friend friend);
}
