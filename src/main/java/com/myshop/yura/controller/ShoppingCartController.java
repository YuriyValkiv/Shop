package com.myshop.yura.controller;

import com.myshop.yura.entity.Lot;
import com.myshop.yura.entity.ShoppingCart;
import com.myshop.yura.entity.Users;
import com.myshop.yura.service.LotService;
import com.myshop.yura.service.ShoppingCartService;
import com.myshop.yura.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    UsersService usersService;

    @Autowired
    LotService lotService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping(value = "shoppingCart")
    public String getShoppingCartPage(ModelMap modelMap) {
        Users loggedUser = new Users();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            loggedUser = user.get(0);
            modelMap.put("username", user.get(0).getName());
        }
        List<ShoppingCart> shoppingCartList = shoppingCartService.getByUser(loggedUser.getName());
        modelMap.put("carts", shoppingCartList);

        //counting total price for products in shopping cart
        List<ShoppingCart> cartList = shoppingCartService.getByUser(loggedUser.getName());
        Iterator<ShoppingCart> iteratorCart = cartList.iterator();
        ShoppingCart sc;
        double price = 0;
        double total = 0;
        while (iteratorCart.hasNext()) {
            sc = iteratorCart.next();
            price = sc.getPrice();
            total += price;
        }
        //6.94 this is estimated shipping
        modelMap.put("subTotal", total);
        total += 6.94;
        modelMap.put("total", total);

        return "shoppingCart";
    }


    @RequestMapping(value = "/addToCart", method = RequestMethod.GET)
    public void addToCart(
            @RequestParam(value = "nameProduct") String productName, ModelMap modelMap
    ) {
        Users loggedUser = new Users();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            loggedUser = user.get(0);
        }
        List<Lot> lotList = lotService.getByName(productName);
        Lot lot = lotList.get(0);
        ShoppingCart shoppingCart = new ShoppingCart(lot.getName(), lot.getPrice(), lot.getImage(), loggedUser.getName());
        List<ShoppingCart> shoppingCartInDBList = shoppingCartService.getByProductName(productName);

        //Check db for having product with the same name, if not put it to db, else ignore
        Iterator<ShoppingCart> iterator = shoppingCartInDBList.iterator();
        if (iterator.hasNext()) {
            ShoppingCart shoppingCartInDB;
            while (iterator.hasNext()) {
                shoppingCartInDB = iterator.next();
                if (!shoppingCartInDB.getName().equals(productName)){
                    shoppingCartService.addCart(shoppingCart);
                }
            }
        } else {
            shoppingCartService.addCart(shoppingCart);
        }
    }

    @RequestMapping(value = "/removeItem", method = RequestMethod.GET)
    public void removeItemFromCart(
            @RequestParam(value = "idProduct") int id
    ) {
        shoppingCartService.removeCart(id);
    }
}