package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import com.test.dao.UserRepository;
import com.test.domain.dto.User;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Controller
public class UserController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value="/signIn")
    public String post(@RequestParam("userId") String userId, @RequestParam("password") String password, @RequestParam("nickname") String nickname, Model model) {
        User user = new User(userId, password, nickname);
        model.addAttribute("user", user);
        return "viewPage";
    }

    @RequestMapping(value="/goBack")
    public String goBack() {
        return "home";
    }

    @RequestMapping(value="/save")
    public String save(@ModelAttribute("user") User user, Model model) {
        mongoTemplate.insert(user, "User");
        User findUser = mongoTemplate.findOne(query(where("userId").is(user.getuserId())), User.class);
        model.addAttribute("finduser", findUser);
        return "save";
    }

}