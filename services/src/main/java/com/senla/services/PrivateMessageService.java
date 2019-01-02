package com.senla.services;

import com.senla.model.dao.api.IFriendDao;
import com.senla.model.dao.api.IPrivateMessageDao;
import com.senla.model.dao.api.IUserDao;
import com.senla.model.entity.Friend;
import com.senla.model.entity.PrivateMessage;
import com.senla.model.entity.User;
import com.senla.services.api.IPrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrivateMessageService implements IPrivateMessageService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IPrivateMessageDao privateMessageDao;
    @Autowired
    private IFriendDao friendDao;

    @Override
    @Transactional
    public void create(PrivateMessage privateMessage) {
        privateMessage.getUsers().add(privateMessage.getRecipient());
        privateMessage.getUsers().add(privateMessage.getSender());
        privateMessageDao.create(privateMessage);
    }

    @Override
    @Transactional
    public List<PrivateMessage> getByUserId(int id) {
        return privateMessageDao.getByUserId(id);
    }

    @Override
    @Transactional
    public Set<User> getDialogsByUserId(int id) {
        Set<User> users = new HashSet<>();
        for (PrivateMessage privateMessage : privateMessageDao.getByUserId(id)) {
            if (privateMessage.getSender().getId() == id) {
                users.add(privateMessage.getRecipient());
            } else users.add(privateMessage.getSender());
        }
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
    public List<PrivateMessage> getDialog(Friend friend) {
        return privateMessageDao.getDialog(friend);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        PrivateMessage privateMessage = privateMessageDao.getById(id);
        User sender = privateMessage.getSender();
        sender.getMessages().remove(privateMessage);
        userDao.update(sender);
    }
}
