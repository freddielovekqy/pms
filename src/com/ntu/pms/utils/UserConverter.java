package com.ntu.pms.utils;

import org.apache.commons.lang.StringUtils;

import com.ntu.pms.dto.UserDTO;
import com.ntu.pms.model.User;

public class UserConverter {

    public static User converterDTOToModel(UserDTO userDTO, User user, boolean isCover) {
        int id = userDTO.getId() != 0 ? userDTO.getId() : user.getId();
        if (isCover) {
            user = new User.Builder(id).name(userDTO.getName()).password(userDTO.getPassword())
                    .jobNumber(userDTO.getJobNumber()).image(userDTO.getImage()).email(userDTO.getEmail()).build();
        } else {
            if (StringUtils.isEmpty(user.getName())) {
                user.setName(userDTO.getName());
            }
            if (StringUtils.isEmpty(user.getPassword())) {
                user.setPassword(userDTO.getPassword());
            }
            if (StringUtils.isEmpty(user.getImage())) {
                user.setImage(userDTO.getImage());
            }
            if (StringUtils.isEmpty(user.getEmail())) {
                user.setEmail(userDTO.getEmail());
            }
            if (StringUtils.isEmpty(user.getJobNumber())) {
                user.setJobNumber(userDTO.getJobNumber());
            }
        }
        return user;
    }

    public static UserDTO converterModelToDTO(User user, UserDTO userDTO, boolean isCover) {
        if (isCover) {
            userDTO.setId(user.getId());
            userDTO.setEmail(user.getEmail());
            userDTO.setName(user.getName());
            userDTO.setImage(user.getImage());
            userDTO.setJobNumber(user.getJobNumber());
            userDTO.setActive(user.getIsActive());
        }
        return userDTO;
    }
}
