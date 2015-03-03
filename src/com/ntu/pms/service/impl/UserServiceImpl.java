package com.ntu.pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.dao.UserDao;
import com.ntu.pms.model.User;
import com.ntu.pms.service.BaseService;
import com.ntu.pms.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(User user) {
        String password = userDao.checkUser(user.getEmail());
        if (password == null || !password.equals(user.getPassword())) {
            user = null;
        } else {
            user = userDao.getUserByEmail(user.getEmail());
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        user.setJobNumber(this.getNewMemberNumber());
        userDao.add(user);
    }

    private String getNewMemberNumber() {
        String jobNumber = userDao.getMaxJobNumber();
        Integer number = Integer.valueOf(jobNumber.substring(1));
        return "W" + (number + 1);
    }
}
