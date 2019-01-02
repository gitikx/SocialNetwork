package com.senla.model.dao.api;


import com.senla.model.entity.PublicMessage;

import java.util.List;

public interface IPublicMessageDao {
    PublicMessage getById(Integer id);

    Boolean update(PublicMessage entity);

    Boolean delete(Integer id);

    Integer create(PublicMessage entity);

    List<PublicMessage> getByForumId(Integer forumId);
}
