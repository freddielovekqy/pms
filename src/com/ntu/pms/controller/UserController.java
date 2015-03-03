package com.ntu.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.constant.PageNameConstant;
import com.ntu.pms.model.User;
import com.ntu.pms.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView initLoginPage() {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_LOGIN);
        return mav;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_REGISTER);
        return mav;
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public User login(User user) {
        user = userService.checkUser(user);
        return user;
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public User saveUser(User user) {
        userService.saveUser(user);
        return user;
    }
}
