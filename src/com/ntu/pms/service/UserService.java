package com.ntu.pms.service;

import com.ntu.pms.dto.ResultObjectDTO;
import com.ntu.pms.model.User;

public interface UserService {

    User checkUser(User user);

    ResultObjectDTO saveUser(User user);

}
