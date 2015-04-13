package com.ntu.pms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ntu.pms.constant.OtherConstants;
import com.ntu.pms.constant.PageNameConstant;
import com.ntu.pms.dto.ResultObjectDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.model.User;
import com.ntu.pms.service.UserService;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView initLoginPage() {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_USER_LOGIN);
        return mav;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_USER_REGISTER);
        return mav;
    }

    @RequestMapping(value = "checkUser", method = RequestMethod.POST)
    public User login(User user, HttpSession session) {
        user = userService.checkUser(user);
        session.setAttribute(OtherConstants.CURRRENT_USER, user);
        return user;
    }

    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ResultObjectDTO saveUser(User user) {
        ResultObjectDTO resultObjectDTO = userService.saveUser(user);
        return resultObjectDTO;
    }

    @RequestMapping(value = "initEditUser", method = RequestMethod.GET)
    public ModelAndView initEditUser() throws BussinessException {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_USER_EDIT_USER);
        UserDTO userDTO = userService.initEditUser(getCurrentLoginUser().getId());
        mav.addObject("userDTO", userDTO);
        return mav;
    }

    @RequestMapping(value = "updateUser")
    public UserDTO updateUser(UserDTO userDTO) {

        return null;
    }
}
