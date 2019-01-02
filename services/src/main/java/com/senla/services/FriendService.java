package com.senla.services;


import com.senla.model.dao.api.IFriendDao;
import com.senla.model.entity.Friend;
import com.senla.model.entity.User;
import com.senla.services.api.IFriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FriendService implements IFriendsService {
    @Autowired
    private IFriendDao friendDao;

    @Override
    @Transactional
    public List<User> getByUserId(int id) {
        List<User> users = new ArrayList<>();
        for (Friend friend : friendDao.getByUserId(id)) {
            if (friend.getFriendTwo().getId() == id) {
                users.add(friend.getFriendOne());
            } else {
                users.add(friend.getFriendTwo());
            }
        }
        return users;
    }

    @Override
    @Transactional
    public List<User> getRequestsById(int id) {
        List<User> requests = new ArrayList<>();
        for (Friend friend :friendDao.getRequestsByUserId(id) ){
            requests.add(friend.getFriendOne());
        }
        return requests;
    }

    @Override
    @Transactional
    public void delete(Friend friend) {
        friendDao.delete(friend);
    }

    @Override
    @Transactional
    public boolean checkFriend(Friend friend) {
        try {
            return friendDao.checkFriend(friend);
        } catch (NoResultException ex) {
            return false;
        }
    }

    @Override
    @Transactional
    public void addFriend(Friend friend) {
        friend.setAccept(Byte.valueOf("0"));
        friendDao.create(friend);
    }

    @Override
    @Transactional
    public void acceptFriend(Friend friend) {
       for(Friend friend1 : friendDao.getRequestsByUserId(friend.getFriendTwo().getId())){
           if(friend1.getFriendOne().getId() == friend.getFriendOne().getId()){
               friend1.setAccept(Byte.valueOf("1"));
               friendDao.update(friend1);
               break;
           }
       }

    }


}
