package com.senla.services.api;


import com.senla.model.entity.News;

import java.util.List;

public interface INewsService {

    void deleteById(Integer id);

    void addNews(News news);

    List<News> getByUserId(int id);
}
