package com.senla.services;

import com.senla.model.dao.api.IPublicMessageDao;
import com.senla.model.entity.PublicMessage;
import com.senla.services.api.IPublicMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PublicMessageService implements IPublicMessageService {

    @Autowired
    private IPublicMessageDao publicMessageDao;

    @Override
    @Transactional
    public List<PublicMessage> getByForumId(Integer forumId) {
        return publicMessageDao.getByForumId(forumId);
    }
}
