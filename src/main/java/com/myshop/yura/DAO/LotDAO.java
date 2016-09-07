package com.myshop.yura.DAO;

import com.myshop.yura.entity.Lot;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LotDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Lot> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Lot.class).list();
    }

    public void removeLot(long id) {
        Session session = sessionFactory.getCurrentSession();
        Lot lot = (Lot) session.get(Lot.class, id);
        if (lot != null) {
            session.delete(lot);
        }
    }

    public Lot getLot(long id) {
        Lot lot = (Lot) sessionFactory.getCurrentSession().get(Lot.class, id);
        return lot;
    }

    public void addLot(Lot lot) {
        Session session = sessionFactory.openSession();
        session.save(lot);
        session.clear();
        session.close();
    }

    public void editLot(Lot lot) {
        Session session = sessionFactory.getCurrentSession();
        Lot lotInDB = (Lot) session.get(Lot.class, lot.getId());

        lotInDB.setName(lot.getName());
        lotInDB.setCountry(lot.getCountry());
        lotInDB.setPrice(lot.getPrice());
        lotInDB.setPrice(lot.getPrice());
        lotInDB.setType(lot.getType());
        lotInDB.setImage(lot.getImage());
        lotInDB.setImageBig(lot.getImageBig());
        lotInDB.setDescription(lot.getDescription());
        lotInDB.setDescriptionBig(lot.getDescriptionBig());

        session.save(lotInDB);
    }

    @SuppressWarnings("unchecked")
    public List<Lot> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Lot.class);
        criteria.add(Restrictions.like("name", name));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Lot> getByType(String type) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Lot.class);
        criteria.add(Restrictions.like("type", type));
        return criteria.list();
    }
}
