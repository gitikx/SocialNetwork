package com.senla.services;


import com.senla.model.dao.api.IForumDao;
import com.senla.model.dao.api.IPublicMessageDao;
import com.senla.model.entity.Forum;
import com.senla.model.entity.PublicMessage;
import com.senla.services.api.IForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ForumService implements IForumService {
    @Autowired
    private IForumDao forumDao;
    @Autowired
    private IPublicMessageDao publicMessageDao;

    @Override
    @Transactional
    public void addForum(Forum forum) {
        forum.getUsers().add(forum.getAdmin());
        forumDao.create(forum);
    }

    @Override
    @Transactional
    public Forum getById(int id) {
        return forumDao.getById(id);
    }

    @Override
    @Transactional
    public List<Forum> getByUserId(Integer id) {
        return forumDao.getByUserId(id);
    }

    @Override
    @Transactional
    public void addMessage(PublicMessage publicMessage) {
        publicMessageDao.create(publicMessage);
    }


}
