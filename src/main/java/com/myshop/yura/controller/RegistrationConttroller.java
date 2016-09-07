package com.myshop.yura.controller;

import com.myshop.yura.entity.Users;
import com.myshop.yura.service.UsersService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationConttroller {


    @Autowired
    private UsersService usersService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
//
//    @RequestMapping(value = "/registration")
//    public String getRegistration(ModelMap modelMap) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            List<Users> user = usersService.getByEmail(userDetails.getUsername());
//            modelMap.put("username", user.get(0).getName());
//        }
//
//        return "registration";
//    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "country") String country,
            @RequestParam(value = "city") String city,
            @RequestParam(value = "password") String password
    ) {
        String pass = RegistrationConttroller.md5Apache(password);
        Users user = new Users(name, email, country, city, pass, "ROLE_USER");
        usersService.addUser(user);

        user.setPassword(password);
        autoLogin(user);
        return new ModelAndView("redirect:/");
    }

    public void autoLogin(Users user) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
            authenticationManager.authenticate(authenticationToken);

            if (authenticationToken.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String md5Apache(String st) {
        return DigestUtils.md5Hex(st);
    }
}
