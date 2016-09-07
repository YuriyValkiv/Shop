package com.myshop.yura.controller;

import com.myshop.yura.entity.Lot;
import com.myshop.yura.entity.Users;
import com.myshop.yura.service.LotService;
import com.myshop.yura.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private LotService lotService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/item")
    public String getItem(
            @RequestParam(value = "name", required = false) String name, ModelMap modelMap
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            modelMap.put("username", user.get(0).getName());
        }

        List<Lot> lot = lotService.getByName(name);
        modelMap.put("product", lot);
        modelMap.put("nameTitle", lot.get(0).getName());
        return "item";
    }
}
