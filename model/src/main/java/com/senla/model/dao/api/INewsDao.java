package com.senla.model.dao.api;


import com.senla.model.entity.News;

import java.util.List;

public interface INewsDao {
    News getById(Integer id);

    Boolean update(News entity);

    Boolean delete(Integer id);

    Integer create(News entity);

    List<News> getByUserId(int id);
}
