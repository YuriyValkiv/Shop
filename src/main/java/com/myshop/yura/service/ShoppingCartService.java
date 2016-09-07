package com.myshop.yura.service;

import com.myshop.yura.DAO.ShoppingCartDAO;
import com.myshop.yura.entity.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartDAO shoppingCartDAO;

    @Transactional
    public ShoppingCart getCart(long id) {
        return shoppingCartDAO.getCart(id);
    }

    @Transactional
    public void removeCart(long id) {
        shoppingCartDAO.removeCart(id);
    }

    @Transactional void editCart(ShoppingCart shoppingCart) {
        shoppingCartDAO.editCart(shoppingCart);
    }

    @Transactional
    public void addCart(ShoppingCart shoppingCart) {
        shoppingCartDAO.addCart(shoppingCart);
    }

    @Transactional
    public List<ShoppingCart> getByUser(String user) {
        return shoppingCartDAO.getByUser(user);
    }

    @Transactional
    public List<ShoppingCart> getByProductName(String name) {
        return  shoppingCartDAO.getByProductName(name);
    }
}
