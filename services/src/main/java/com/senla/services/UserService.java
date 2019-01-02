package com.senla.services;


import com.senla.model.dao.ForumDao;
import com.senla.model.dao.InfoDao;
import com.senla.model.dao.api.IPrivateMessageDao;
import com.senla.model.dao.api.IUserDao;
import com.senla.model.entity.Info;
import com.senla.model.entity.User;
import com.senla.services.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private InfoDao infoDao;

    @Override
    @Transactional
    public User getById(Integer id) {
        return userDao.getById(id);
    }


    @Override
    @Transactional
    public Integer create(User user, Info info) throws Exception {
        int id = userDao.create(user);
        info.getUser().setId(id);
        infoDao.create(info);
        return id;
    }

    @Override
    @Transactional
    public List<User> getAllUsers(Info info) {
       return userDao.getAll(info);

    }

}
