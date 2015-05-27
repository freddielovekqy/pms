package com.ntu.pms.service;

import com.ntu.pms.dto.ResultObjectDTO;
import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.exception.BussinessException;
import com.ntu.pms.model.User;

public interface UserService {

    UserDTO checkUser(UserDTO userDTO);

    ResultObjectDTO saveUser(User user);

    UserDTO initEditUser(int id) throws BussinessException;

    UserDTO getUserDTO(int id) throws BussinessException;

    User getUserById(int id) throws BussinessException;

    UserDTO updateUser(UserDTO userDTO) throws BussinessException;

}
