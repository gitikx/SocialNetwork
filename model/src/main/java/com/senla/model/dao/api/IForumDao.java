package com.senla.model.dao.api;


import com.senla.model.entity.Forum;

import java.util.List;

public interface IForumDao {
    Forum getById(Integer id);

    Boolean update(Forum entity);

    Boolean delete(Integer id);

    Integer create(Forum entity);

    List<Forum> getByUserId(int id);
}
