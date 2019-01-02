package com.senla.model.dao;

import com.senla.model.dao.api.IInfoDao;
import com.senla.model.entity.Info;
import com.senla.model.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;

@Repository
public class InfoDao extends GenericDao<Info, Integer> implements IInfoDao {
    public InfoDao() {
        super(Info.class);
    }

    @Override
    public Info getByUserId(int id) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Info> criteriaQuery = criteriaBuilder.createQuery(Info.class);
        Root<Info> rootInfo = criteriaQuery.from(Info.class);
        Join<Info, User> join = rootInfo.join("user", JoinType.INNER);
        criteriaQuery.select(rootInfo);
        criteriaQuery.where(criteriaBuilder.equal(join.get("id"),id));
        return getCurrentSession().createQuery(criteriaQuery).getSingleResult();
    }
}
