package com.ntu.pms.service;

import com.ntu.pms.model.User;

public interface UserService {

    User checkUser(User user);

    void saveUser(User user);

}
