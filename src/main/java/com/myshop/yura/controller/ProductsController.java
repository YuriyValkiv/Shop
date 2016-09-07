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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    private LotService lotService;

    @Autowired
    private UsersService usersService;

    List<Lot> lots;

    @RequestMapping(value = "/products")
    public String getProducts(
            @RequestParam(value = "type", required = false) String type, ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            modelMap.put("username", user.get(0).getName());
        }

        if (type != null) {
            lots = lotService.getByType(type);
            modelMap.put("activeListItemTwo", "active");
        } else {
            lots = lotService.getByType("smartphone");
            modelMap.put("activeListItemOne", "active");
        }
        ArrayList<Integer> randomPhoto = new ArrayList<>();
        for (int i = 0; i < lots.size(); i++) {
            randomPhoto.add(i);
        }
        Collections.shuffle(randomPhoto);
        modelMap.put("bigImageOne", lots.get(randomPhoto.get(0)).getImageBig());
        modelMap.put("bigImageTwo", lots.get(randomPhoto.get(1)).getImageBig());
        modelMap.put("bigImageThree", lots.get(randomPhoto.get(2)).getImageBig());

        modelMap.put("products", lots);
        return "products";
    }
}
