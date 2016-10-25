package com.myshop.yura.DAO;

import com.myshop.yura.entity.Comments;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addComment(Comments comment) {
        Session session = sessionFactory.openSession();
        session.save(comment);
        session.clear();
        session.close();
    }

    public void removeComment(long id) {
        Session session = sessionFactory.getCurrentSession();
        Comments comment = (Comments) session.get(Comments.class, id);
        if (comment != null) session.delete(comment);
    }

    @SuppressWarnings("unchecked")
    public List<Comments> getByLotName(String lot_name) {
        Session session =sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Comments.class);
        criteria.add(Restrictions.like("lot_name", lot_name));
        return criteria.list();
    }
}
