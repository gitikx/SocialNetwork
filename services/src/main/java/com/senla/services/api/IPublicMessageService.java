package com.senla.services.api;


import com.senla.model.entity.PublicMessage;

import java.util.List;

public interface IPublicMessageService {
    List<PublicMessage> getByForumId(Integer forumId);
}
