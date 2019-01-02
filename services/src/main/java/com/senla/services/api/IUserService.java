package com.senla.services.api;



import com.senla.model.entity.Info;
import com.senla.model.entity.User;

import java.util.List;

public interface IUserService {
    User getById(Integer id);


    Integer create(User user, Info info) throws Exception;

    List<User> getAllUsers(Info info);
}
