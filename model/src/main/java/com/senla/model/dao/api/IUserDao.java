package com.senla.model.dao.api;


import com.senla.model.entity.Info;
import com.senla.model.entity.User;

import javax.persistence.NoResultException;
import java.util.List;

public interface IUserDao {
    User getById(Integer id);

    Boolean update(User entity);

    Boolean delete(Integer id);

    Integer create(User entity) throws Exception;

    User getByLogin(String login) throws NoResultException;

    List<User> getAll(Info info);

    void merge(User user);
}
