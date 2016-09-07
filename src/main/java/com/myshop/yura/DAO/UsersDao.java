package com.myshop.yura.DAO;

import com.myshop.yura.entity.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Users> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(Users.class).list();
    }

    public void removeUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users) session.get(Users.class, id);
        if (user != null) {
            session.delete(user);
        }
    }

    public Users getLot(long id) {
        Users user = (Users) sessionFactory.getCurrentSession().get(Users.class, id);
        return user;
    }

    public void addUser(Users user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.clear();
        session.close();
    }

    public void editUser(Users user) {
        Session session = sessionFactory.getCurrentSession();
        Users userInDB = (Users) session.get(Users.class, user.getId());

        userInDB.setName(user.getName());
        userInDB.setCity(user.getCity());
        userInDB.setCountry(user.getCountry());
        userInDB.setEmail(user.getEmail());
        userInDB.setPassword(user.getPassword());
        userInDB.setRole(user.getRole());

        session.save(userInDB);
    }

    @SuppressWarnings("unchecked")
    public List<Users> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.like("name", name));
        List <Users> user = criteria.list();
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<Users> getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.like("email", email));
        return criteria.list();
    }
}
