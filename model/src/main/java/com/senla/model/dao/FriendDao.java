package com.senla.model.dao;

import com.senla.model.dao.api.IFriendDao;
import com.senla.model.entity.Friend;
import com.senla.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class FriendDao extends GenericDao<Friend, Integer> implements IFriendDao {
    public FriendDao() {
        super(Friend.class);
    }

    @Override
    public List<Friend> getByUserId(int id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Friend> criteriaQuery = criteriaBuilder.createQuery(Friend.class);
        Root<Friend> root = criteriaQuery.from(Friend.class);
        Join<Friend, User> join1 = root.join("friendOne");
        Join<Friend, User> join2 = root.join("friendTwo");
        Predicate cond = null;
        Predicate cond2 = null;
        cond = criteriaBuilder.or((criteriaBuilder.equal(join1.get("id"), id)), criteriaBuilder.equal(join2.get("id"), id));
        cond2 = criteriaBuilder.and(criteriaBuilder.equal(root.get("deleted"), Byte.valueOf("0")));
        Predicate cond3 = criteriaBuilder.and(criteriaBuilder.equal(root.get("accept"), Byte.valueOf("1")));
        criteriaQuery.select(root).where(cond, cond2, cond3);
        return getCurrentSession().createQuery(criteriaQuery).list();
    }

    @Override
    public Boolean delete(Friend friend) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Friend> criteriaQuery= criteriaBuilder.createQuery(Friend.class);
        Root<Friend> root = criteriaQuery.from(Friend.class);
        Join<Friend, User> join1 = root.join("friendOne");
        Join<Friend, User> join2 = root.join("friendTwo");
        Predicate cond, cond2, cond3;
        cond = criteriaBuilder.or((criteriaBuilder.equal(join1.get("id"), friend.getFriendOne().getId())), criteriaBuilder.equal(join1.get("id"), friend.getFriendTwo().getId()));
        cond3 = criteriaBuilder.or((criteriaBuilder.equal(join2.get("id"), friend.getFriendTwo().getId())), criteriaBuilder.equal(join2.get("id"), friend.getFriendOne().getId()));
        cond2 = criteriaBuilder.and(criteriaBuilder.equal(root.get("deleted"), Byte.valueOf("0")));
        criteriaQuery.where(cond, cond2, cond3);
        Friend friend1 = getCurrentSession().createQuery(criteriaQuery).getSingleResult();
        friend1.setDeleted(Byte.valueOf("1"));
        update(friend1);
        return null;
    }

    @Override
    public boolean checkFriend(Friend friend) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Friend> criteriaQuery= criteriaBuilder.createQuery(Friend.class);
        Root<Friend> root = criteriaQuery.from(Friend.class);
        Join<Friend, User> join1 = root.join("friendOne");
        Join<Friend, User> join2 = root.join("friendTwo");
        Predicate cond, cond2, cond3, cond4;
        cond = criteriaBuilder.or((criteriaBuilder.equal(join1.get("id"), friend.getFriendOne().getId())), criteriaBuilder.equal(join1.get("id"), friend.getFriendTwo().getId()));
        cond3 = criteriaBuilder.or((criteriaBuilder.equal(join2.get("id"), friend.getFriendTwo().getId())), criteriaBuilder.equal(join2.get("id"), friend.getFriendOne().getId()));
        cond2 = criteriaBuilder.and(criteriaBuilder.equal(root.get("deleted"), Byte.valueOf("0")));
        cond4 = criteriaBuilder.and(criteriaBuilder.equal(root.get("accept"), Byte.valueOf("1")));
        criteriaQuery.where(cond, cond2, cond3, cond4);
        getCurrentSession().createQuery(criteriaQuery).getSingleResult();
        return true;
    }

    @Override
    public List<Friend> getRequestsByUserId(int id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Friend> criteriaQuery = criteriaBuilder.createQuery(Friend.class);
        Root<Friend> root = criteriaQuery.from(Friend.class);
        Join<Friend, User> join1 = root.join("friendTwo");
        Predicate cond = (criteriaBuilder.equal(join1.get("id"), id));
        Predicate cond2 = criteriaBuilder.and(criteriaBuilder.equal(root.get("deleted"), Byte.valueOf("0")));
        Predicate cond3 = criteriaBuilder.and(criteriaBuilder.equal(root.get("accept"), Byte.valueOf("0")));
        criteriaQuery.select(root).where(cond, cond2, cond3);
        return getCurrentSession().createQuery(criteriaQuery).list();
    }
}

