package com.ntu.pms.dao.impl;

import org.springframework.stereotype.Repository;

import com.ntu.pms.dao.BaseDaoImpl;
import com.ntu.pms.dao.UserDao;
import com.ntu.pms.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

    private static final String SQL_ID_GET_MAX_JOB_NUMBER = ".getMaxJobNumber";
    private static final String SQL_ID_CHECK_USER = ".checkUser";
    private static final String SQL_ID_GET_USER_BY_EMAIL = "¡£getUserByEmail";

    @Override
    public String getMaxJobNumber() {
        String jobNumber = getSqlSession().selectOne(User.class.getName() + SQL_ID_GET_MAX_JOB_NUMBER);
        return jobNumber;
    }

    @Override
    public String checkUser(String email) {
        String password = getSqlSession().selectOne(User.class.getName() + SQL_ID_CHECK_USER, email);
        return password;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = getSqlSession().selectOne(User.class.getName() + SQL_ID_GET_USER_BY_EMAIL, email);
        return user;
    }

}
