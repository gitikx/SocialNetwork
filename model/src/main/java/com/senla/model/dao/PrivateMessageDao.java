package com.senla.model.dao;

import com.senla.model.dao.api.IPrivateMessageDao;
import com.senla.model.entity.Friend;
import com.senla.model.entity.PrivateMessage;
import com.senla.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PrivateMessageDao extends GenericDao<PrivateMessage, Integer> implements IPrivateMessageDao {
    public PrivateMessageDao() {
        super(PrivateMessage.class);
    }

    @Override
    public List<PrivateMessage> getByUserId(int id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<PrivateMessage> criteriaQuery = criteriaBuilder.createQuery(PrivateMessage.class);
        Root<User> root = criteriaQuery.from(User.class);
        Join<User, PrivateMessage> join = root.join("messages", JoinType.INNER);
        criteriaQuery.select(join);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
        return getCurrentSession().createQuery(criteriaQuery).list();
    }

    @Override
    public List<PrivateMessage> getDialog(Friend friend) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<PrivateMessage> criteriaQuery = criteriaBuilder.createQuery(PrivateMessage.class);
        Root<User> root = criteriaQuery.from(User.class);
        Join<User, PrivateMessage> join = root.join("messages", JoinType.INNER);
        Predicate cond1 = criteriaBuilder.or(criteriaBuilder.equal(join.get("sender"), friend.getFriendOne().getId()), criteriaBuilder.equal(join.get("recipient"), friend.getFriendOne().getId()));
        Predicate cond2 = criteriaBuilder.or(criteriaBuilder.equal(join.get("sender"), friend.getFriendTwo().getId()), criteriaBuilder.equal(join.get("recipient"), friend.getFriendTwo().getId()));
        Predicate cond3 = criteriaBuilder.equal(root.get("id"), friend.getFriendOne().getId());
        criteriaQuery.select(join);
        criteriaQuery.where(cond1, cond2, cond3);
        return getCurrentSession().createQuery(criteriaQuery).list();
    }
}
