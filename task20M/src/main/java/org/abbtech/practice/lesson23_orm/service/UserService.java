package org.abbtech.practice.lesson23_orm.service;

import org.abbtech.practice.lesson23_orm.dto.*;
import org.abbtech.practice.lesson23_orm.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
   UserInfo createUser(UserDTO userDTO);
   void saveUser(UserDTO userRequest);
}
