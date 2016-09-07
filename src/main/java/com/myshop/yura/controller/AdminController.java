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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private LotService lotService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/admin")
    public String getAdminPage(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            List<Users> user = usersService.getByEmail(userDetails.getUsername());
            modelMap.put("username", user.get(0).getName());
        }

        return "admin";
    }

    String imageDir;
    @RequestMapping(value = "/admin/add")
    private String addToDB(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "type") String type,
            @RequestParam(value = "country") String country,
            @RequestParam(value = "price") double price,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "descriptionBig") String descriptionBig,
            @RequestParam(value = "image") MultipartFile image,
            @RequestParam(value = "imageBig") MultipartFile imageBig, ModelMap modelMap
    ) {
        String imageName = image.getOriginalFilename();
        String imageBigName = imageBig.getOriginalFilename();
//        String workingDir = AdminController.class.getResource("/src/main/java/com/myshop/yura/controller/AdminController.java").getPath();
        String workingDir = "work";
        System.out.println(workingDir);
        switch (type) {
            case "smartphone": imageDir = "phones";
                break;
            case "notebook": imageDir = "notebooks";
                break;
        }
//        System.out.println(imageDir);
//        //TODO: fix path in linux (everything which are below work fine in windows
////        String pathForImage = workingDir+"../../../../../../../../src/main/webapp/resources/images/" + imageDir;
////        String pathForImageBig = workingDir+"../../../../../../../../src/main/webapp/resources/images/" + imageDir + "/bigImg/";
//        String pathForImage = workingDir + "/src/main/webapp/resources/images/" + imageDir;
//        String pathForImageBig = workingDir + "/src/main/webapp/resources/images/" + imageDir + "/bigImg/";
//        if (!image.isEmpty() && !imageBig.isEmpty()) {
//            try {
//                byte [] bytesImage = image.getBytes();
//                byte [] bytesImageBig = imageBig.getBytes();
//                BufferedOutputStream streamImage = new BufferedOutputStream(new FileOutputStream(new File(pathForImage + imageName)));
//                BufferedOutputStream streamImageBig = new BufferedOutputStream(new FileOutputStream(new File(pathForImageBig + imageBigName)));
//                streamImageBig.write(bytesImageBig);
//                streamImageBig.close();
//                streamImage.write(bytesImage);
//                streamImage.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("fail");
//        }
//
//        String imageNew = "/resources/images/" + imageDir +"/" + imageName;
//        String imageBigNew = "/resources/images/" + imageDir + "/bigImg/" + imageBigName;
//        Lot lot = new Lot(name, type, price, country, imageNew, imageBigNew, description, descriptionBig);
//        lotService.addLot(lot);
        return "admin";
    }

}
