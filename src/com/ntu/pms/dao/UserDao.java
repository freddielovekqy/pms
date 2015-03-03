package com.ntu.pms.dao;

import com.ntu.pms.model.User;

public interface UserDao extends BaseDao<User, Integer> {

    String getMaxJobNumber();

    String checkUser(String email);

    User getUserByEmail(String email);
}
