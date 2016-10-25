package com.myshop.yura.controller;

import com.myshop.yura.entity.Comments;
import com.myshop.yura.entity.Lot;
import com.myshop.yura.entity.Users;
import com.myshop.yura.service.CommentsService;
import com.myshop.yura.service.LotService;
import com.myshop.yura.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private LotService lotService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CommentsService commentsService;

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
        Lot lotToPage = lot.get(0);
        modelMap.put("lotName", lotToPage.getName());
        modelMap.put("product", lot);
        modelMap.put("nameTitle", lot.get(0).getName());

        //list of comments for page
        List<Comments> commentsList = commentsService.getByLotName(lotToPage.getName());
        modelMap.put("commentsList", commentsList);

        //number of reviews for current product
        int reviews = commentsList.size();
        modelMap.put("reviews", reviews);
        return "item";
    }

    @RequestMapping(value = "/newComment")
    public ModelAndView addCommentToDB(
            @RequestParam(value = "comment") String comment,
            @RequestParam(value = "product") String lot_name
    ) {
        //adding new comment to DB
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            Comments commentToDB = new Comments(user.get(0).getName(), dateFormat.format(date), comment, lot_name);
            commentsService.addComment(commentToDB);
        } else {
            Comments commentToDB = new Comments("Anonymous", dateFormat.format(date), comment, lot_name);
            commentsService.addComment(commentToDB);
        }
        return new ModelAndView("redirect:/item?name="+lot_name);
    }
}
