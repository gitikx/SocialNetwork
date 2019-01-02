package com.senla.model.dao;

import com.senla.model.dao.api.INewsDao;

import com.senla.model.entity.News;
import com.senla.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class NewsDao extends GenericDao<News, Integer> implements INewsDao {
    public NewsDao() {
        super(News.class);
    }

    @Override
    public List<News> getByUserId(int id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<News> criteriaQuery = criteriaBuilder.createQuery(News.class);
        Root<News> root = criteriaQuery.from(News.class);
        Join<News, User> join = root.join("user", JoinType.INNER);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(join.get("id"), id));
        return getCurrentSession().createQuery(criteriaQuery).list();
    }
}
