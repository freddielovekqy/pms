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
    public UserDTO login(UserDTO userDTO, HttpSession session) {
        userDTO = userService.checkUser(userDTO);
        setBaseDataMap(OtherConstants.CURRRENT_USER, userDTO);
        session.setAttribute(OtherConstants.CURRRENT_USER, userDTO);
        return userDTO;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        ModelAndView mav = new ModelAndView(PageNameConstant.PAGE_NAME_USER_LOGOUT);
        removeBaseData(OtherConstants.CURRRENT_USER);
        session.removeAttribute(OtherConstants.CURRRENT_USER);
        return mav;
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

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public UserDTO updateUser(UserDTO userDTO, HttpSession session) throws BussinessException {
        userDTO = userService.updateUser(userDTO);
        setBaseDataMap(OtherConstants.CURRRENT_USER, userDTO);
        session.setAttribute(OtherConstants.CURRRENT_USER, userDTO);
        return userDTO;
    }

}
