package com.senla.services.api;


import com.senla.model.entity.Info;

public interface IInfoService {

    Info getByUserId(Integer id);

    void update(Info info);
}
