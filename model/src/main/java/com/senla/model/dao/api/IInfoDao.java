package com.senla.model.dao.api;

import com.senla.model.entity.Info;

public interface IInfoDao {
    Info getById(Integer id);

    Boolean update(Info entity);

    Boolean delete(Integer id);

    Integer create(Info entity);

    Info getByUserId(int id);
}
