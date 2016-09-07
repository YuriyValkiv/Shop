package com.myshop.yura.DAO;

import com.myshop.yura.entity.ShoppingCart;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoppingCartDAO {

    @Autowired
    SessionFactory sessionFactory;

    public ShoppingCart getCart(long id) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().get(ShoppingCart.class, id);
        return shoppingCart;
    }

    public void removeCart(long id) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.get(ShoppingCart.class, id);
        if (session != null) {
            session.delete(shoppingCart);
        }
    }

    public void editCart(ShoppingCart shoppingCart) {
        Session session = sessionFactory.getCurrentSession();
        ShoppingCart shoppingCartInDB = (ShoppingCart) session.get(ShoppingCart.class, shoppingCart.getId());

        shoppingCartInDB.setName(shoppingCart.getName());
        shoppingCartInDB.setPrice(shoppingCart.getPrice());
        shoppingCartInDB.setImage(shoppingCart.getImage());
        shoppingCartInDB.setUser(shoppingCart.getUser());
    }

    public void addCart(ShoppingCart shoppingCart) {
        Session session = sessionFactory.openSession();
        session.save(shoppingCart);
        session.clear();
        session.close();
    }

    @SuppressWarnings("uncheked")
    public List<ShoppingCart> getByUser(String user) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ShoppingCart.class);
        criteria.add(Restrictions.like("user", user));
        return criteria.list();
    }

    @SuppressWarnings("uncheked")
    public List<ShoppingCart> getByProductName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ShoppingCart.class);
        criteria.add(Restrictions.like("name", name));
        return criteria.list();
    }
}
