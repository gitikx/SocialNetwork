package com.senla.services;


import com.senla.model.dao.UserDao;
import com.senla.model.entity.User;
import com.senla.services.api.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;


@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Integer checkCredentials(User user) {
        try {
            User user1 = userDao.getByLogin(user.getLogin());
            if (user1.getPassword().equals(user.getPassword())) {
                return user1.getId();
            } else {
                return null;
            }
        } catch (NoResultException ex) {
            return null;
        }
    }
}
