package com.senla.services;

import com.senla.model.dao.api.IFriendDao;
import com.senla.model.dao.api.INewsDao;
import com.senla.model.entity.Friend;
import com.senla.model.entity.News;
import com.senla.services.api.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    private INewsDao newsDao;
    @Autowired
    private IFriendDao friendDao;

    @Override
    @Transactional
    public void deleteById(Integer newsId) {
        newsDao.delete(newsId);
    }

    @Override
    @Transactional
    public void addNews(News news) {
        newsDao.create(news);
    }

    @Override
    @Transactional
    public List<News> getByUserId(int id) {
        List<News> news = new ArrayList<>();
        for (Friend friend : friendDao.getByUserId(id)) {
            if (friend.getFriendTwo().getId() == id) {
                for(News news1 : newsDao.getByUserId(friend.getFriendOne().getId())){
                    news.add(news1);
                }
            } else {
                for(News news1 : newsDao.getByUserId(friend.getFriendTwo().getId())){
                    news.add(news1);
                }
            }
        }
        for(News news1 : newsDao.getByUserId(id)){
            news.add(news1);
        }
        return news;
    }
}
