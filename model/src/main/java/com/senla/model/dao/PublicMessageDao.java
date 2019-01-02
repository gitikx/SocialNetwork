package com.senla.model.dao;

import com.senla.model.dao.api.IPublicMessageDao;
import com.senla.model.entity.Forum;
import com.senla.model.entity.PublicMessage;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class PublicMessageDao extends GenericDao<PublicMessage, Integer> implements IPublicMessageDao {
    public PublicMessageDao() {
        super(PublicMessage.class);
    }

    @Override
    public List<PublicMessage> getByForumId(Integer forumId) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<PublicMessage> criteriaQuery = criteriaBuilder.createQuery(PublicMessage.class);
        Root<PublicMessage> root = criteriaQuery.from(PublicMessage.class);
        Join<PublicMessage, Forum> join = root.join("forum");
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.equal(join.get("id"), forumId));
        return getCurrentSession().createQuery(criteriaQuery).list();
    }
}
