package com.senla.services.api;


import com.senla.model.entity.User;

public interface IAuthService {
    Integer checkCredentials(User user);
}
