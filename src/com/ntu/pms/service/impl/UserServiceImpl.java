package com.ntu.pms.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntu.pms.constant.EntityConstants;
import com.ntu.pms.dao.UserDao;
import com.ntu.pms.dto.ResultObjectDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
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
    public ResultObjectDTO saveUser(User user) {
        ResultObjectDTO resultObjectDTO = new ResultObjectDTO();
        User oldUser = userDao.getUserByEmail(user.getEmail());

        if (oldUser != null) {
            resultObjectDTO.setStatus(0);
            resultObjectDTO.setReturnMessage("∏√” œ‰“—±ª◊¢≤·");
        } else {
            user.setJobNumber(this.getNewMemberNumber());
            userDao.add(user);
            resultObjectDTO.setStatus(1);
            resultObjectDTO.setResultObject(userDao.getUserByEmail(user.getEmail()));
        }
        return resultObjectDTO;
    }

    private String getNewMemberNumber() {
        String jobNumber = userDao.getMaxJobNumber();
        Integer number = Integer.valueOf(jobNumber.substring(1));
        return "W" + String.format("%05d", (number + 1));
    }

    @Override
    public UserDTO initEditUser(int id) throws BussinessException {
        return this.getUserDTO(id);
    }

    @Override
    public UserDTO getUserDTO(int id) throws BussinessException {
        UserDTO userDTO = userDao.getUserDTOById(id);
        if (userDTO == null || BooleanUtils.isFalse(userDTO.getIsActive())) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(EntityConstants.OBJECT_TYPE, EntityConstants.USER);
            map.put(EntityConstants.OBJECT_ID, id);
            throw new BussinessException("No user or user exit.", map);
        }
        return userDTO;
    }

    @Override
    public User getUser(int id) throws BussinessException {
        User user = userDao.getById(id);
        if (user == null || BooleanUtils.isFalse(user.getIsActive())) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(EntityConstants.OBJECT_TYPE, EntityConstants.USER);
            map.put(EntityConstants.OBJECT_ID, id);
            throw new BussinessException("No user or user exit.", map);
        }
        return user;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) throws BussinessException {
        User user = this.getUser(userDTO.getId());
        return null;
    }
}
