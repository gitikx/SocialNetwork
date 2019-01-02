package com.senla.services.api;


import com.senla.model.entity.Friend;
import com.senla.model.entity.PrivateMessage;
import com.senla.model.entity.User;

import java.util.List;
import java.util.Set;

public interface IPrivateMessageService {
    void delete(Integer id);

    void create(PrivateMessage privateMessage);

    List<PrivateMessage>getByUserId(int id);

    Set<User> getDialogsByUserId(int id);

    List<PrivateMessage> getDialog(Friend friend);
}
