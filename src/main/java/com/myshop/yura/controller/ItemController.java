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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
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

        /*
         * average star rating
         */
        int rating = 0;
        int numberOfComments = commentsList.size();
        Iterator<Comments> commentsIterator = commentsList.iterator();
        while (commentsIterator.hasNext()) {
            rating += commentsIterator.next().getStars();
        }
        System.out.println(numberOfComments);
        System.out.println(rating);
        int resultRating = 0;
        try {
            resultRating = rating/numberOfComments;
        } catch (ArithmeticException e) {
            resultRating = 0;
        }
        byte resRat = (byte) resultRating;
        String itemStarRating = getStarsRating(resRat);
        modelMap.put("itemStarRating", itemStarRating);
        modelMap.put("itemRating", resultRating);
        modelMap.put("numberOfComments", numberOfComments);
        return "item";
    }

    @RequestMapping(value = "/newComment", method = RequestMethod.GET)
    public @ResponseBody String addCommentToDB(
            @RequestParam(value = "product") String lot_name,
            @RequestParam(value = "comment") String comment,
            @RequestParam(value = "stars") byte stars
    ) {
        /*
         *adding new comment to DB
         */
        System.out.println("I am in adding to db comment method");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        String authorToPage = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            Comments commentToDB = new Comments(user.get(0).getName(), dateFormat.format(date), comment, lot_name, stars);
            commentsService.addComment(commentToDB);
            authorToPage = user.get(0).getName();
        } else {
            Comments commentToDB = new Comments("Anonymous", dateFormat.format(date), comment, lot_name, stars);
            commentsService.addComment(commentToDB);
            authorToPage = "Anonymous";
        }
        String starsToPage = getStarsRating(stars);
        return "<hr><div class=\"row\">\n" +
                "   <div class=\"col-md-12\">\n" +starsToPage+"\n"+
                "       "+authorToPage+"\n" +
                "       <span class=\"pull-right\">"+dateFormat.format(date)+"</span>\n" +
                "       <p>"+comment+"</p>\n" +
                "   </div>\n" +
                "</div>";
    }

    private String getStarsRating(byte stars) {
        String starsToPage = "";
        switch (stars) {
            case 1:
                starsToPage = "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>";
                break;
            case 2:
                starsToPage = "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>";
                break;
            case 3:
                starsToPage = "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>";
                break;
            case 4:
                starsToPage = "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>";
                break;
            case 5:
                starsToPage = "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>" +
                        "<span class=\"glyphicon glyphicon-star\"></span>";
                break;
            default:
                starsToPage = "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>" +
                        "<span class=\"glyphicon glyphicon-star-empty\"></span>";
                break;
        }
    return starsToPage;
    }
}
