package com.senla.model.dao.api;

import com.senla.model.entity.Friend;
import com.senla.model.entity.PrivateMessage;

import java.util.List;

public interface IPrivateMessageDao {
    PrivateMessage getById(Integer id);

    Boolean update(PrivateMessage entity);

    Boolean delete(Integer id);

    Integer create(PrivateMessage entity);

    List<PrivateMessage> getByUserId(int id);

    List<PrivateMessage> getDialog(Friend friend);
}
