package com.senla.model.dao;


import com.senla.model.dao.api.IUserDao;
import com.senla.model.entity.Info;
import com.senla.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class UserDao extends GenericDao<User, Integer> implements IUserDao {
    public UserDao() {
        super(User.class);
    }

    public User getByLogin(String login) throws NoResultException {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(criteriaBuilder.equal(root.get("login"), login));
        return getCurrentSession().createQuery(query).getSingleResult();
    }

    @Override
    public List<User> getAll(Info info) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<Info> root = criteriaQuery.from(Info.class);
        Join<Info, User> join1 = root.join("user");
        Predicate cond = null;
        Predicate cond2 = null;
        cond = criteriaBuilder.or((criteriaBuilder.like(root.get("name"), info.getName())), criteriaBuilder.like(root.get("surname"), info.getSurname()));
        cond2 = criteriaBuilder.and((criteriaBuilder.equal(join1.get("blocked"), Byte.valueOf("0"))));
        criteriaQuery.select(join1).where(cond, cond2);
        return getCurrentSession().createQuery(criteriaQuery).list();
    }

    @Override
    public void merge(User user) {
        getCurrentSession().merge("user", user);
    }
}
