package com.myshop.yura.service;

import com.myshop.yura.DAO.UsersDao;
import com.myshop.yura.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersDao usersDao;

    @Transactional
    public List<Users> getAll() {
        return usersDao.getAll();
    }

    @Transactional
    public void removeUser(long id) {
        usersDao.removeUser(id);
    }

    @Transactional
    public void addUser(Users user) {
        usersDao.addUser(user);
    }

    @Transactional
    public void editUser(Users user) {
        usersDao.editUser(user);
    }

    @Transactional
    public List<Users> getByName(String name) {
        return usersDao.getByName(name);
    }

    @Transactional
    public List<Users> getByEmail(String email) {
        return usersDao.getByEmail(email);
    }
}
