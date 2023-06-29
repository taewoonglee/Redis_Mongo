package com.test.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import com.test.dao.UserRepository;
import com.test.domain.dto.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Controller
public class UserController {

    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/signIn")
    public ModelAndView post(@RequestParam("userId") String userId, @RequestParam("password") String password, @RequestParam("nickname") String nickname, Model model
    ) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("viewPage");
        User user = new User(userId, password, nickname);
        model.addAttribute("user", user);
        return modelAndView;
    }

    @RequestMapping(value="/goBack")
    public String goBack() {
        return "home";
    }

    @GetMapping(value="/save")
    public ModelAndView save(@ModelAttribute("user") User user, Model model) {
        ModelAndView modelAndView=new ModelAndView();

        User user1=new User("dokyeon", "1234", "dodo");
        User user2=new User("dokyeon2", "12342", "dodo2");

        DBObject document = new BasicDBObject();

        document.put("userId", "24352345");
        mongoTemplate.insert(user1,"User");
        mongoTemplate.insert(document, "User");
        Query query = new Query(Criteria.where("_id").is("649d4c458e6b5e240bddfbe3"));
        List<User> results = mongoTemplate.find(query, User.class, "User");
        System.out.println(results);
        modelAndView.setViewName("save");
        modelAndView.addObject("finduser",results);
        return modelAndView;
    }

}