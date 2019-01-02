package com.senla.services.api;



import com.senla.model.entity.Forum;
import com.senla.model.entity.PublicMessage;

import java.util.List;

public interface IForumService {

    void addForum(Forum forum);

    Forum getById(int id);

    List<Forum> getByUserId(Integer id);

    void addMessage(PublicMessage publicMessage);
}
