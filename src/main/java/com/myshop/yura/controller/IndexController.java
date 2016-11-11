package com.myshop.yura.controller;

import com.myshop.yura.entity.ShoppingCart;
import com.myshop.yura.entity.Users;
import com.myshop.yura.service.ShoppingCartService;
import com.myshop.yura.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/")
    public String getIndex(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            modelMap.put("username", user.get(0).getName());
        }

        return "index";
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());

            /*
             * deleting user shoppingCart after logout
             */
            List<ShoppingCart> shoppingCartUser = shoppingCartService.getByUser(user.get(0).getName());
            Iterator<ShoppingCart> iterator = shoppingCartUser.iterator();
            while (iterator.hasNext()) {
                shoppingCartService.removeCart(iterator.next().getId());
            }
        }
        return new ModelAndView("redirect:/");
    }
}
