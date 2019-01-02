package com.senla.model.dao;


import com.senla.model.dao.api.IForumDao;
import com.senla.model.entity.Forum;
import com.senla.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class ForumDao extends GenericDao<Forum, Integer> implements IForumDao {
    public ForumDao() {
        super(Forum.class);
    }

    @Override
    public List<Forum> getByUserId(int id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Forum> criteriaQuery = criteriaBuilder.createQuery(Forum.class);
        Root<Forum> root = criteriaQuery.from(Forum.class);
        Join<Forum, User> join = root.join("users");
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(join.get("id"), id));
        return getCurrentSession().createQuery(criteriaQuery).list();
    }
}
