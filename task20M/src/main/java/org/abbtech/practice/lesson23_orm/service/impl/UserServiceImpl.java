package org.abbtech.practice.lesson23_orm.service.impl;

import lombok.RequiredArgsConstructor;
import org.abbtech.practice.lesson23_orm.dto.*;
import org.abbtech.practice.lesson23_orm.model.UserInfo;
import org.abbtech.practice.lesson23_orm.model.UserRole;
import org.abbtech.practice.lesson23_orm.repository.UserRepository;
import org.abbtech.practice.lesson23_orm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserInfo createUser(UserDTO userDTO) {
        UserInfo user = new UserInfo();
        user.setUsername(userDTO.username());
        user.setPassword(userDTO.password());
        user.setEmail(userDTO.email());
       return userRepository.save(user);
    }
    @Override
    public void saveUser(UserDTO userRequest) {
        var userinfo = UserInfo.builder()
                .email(userRequest.username())
                .username(userRequest.username())
                .password(bCryptPasswordEncoder.encode(userRequest.password()))
                .build();
        userinfo.setUserRoles(userRequest.roles().stream()
                .map(string -> UserRole.builder()
                        .userInfo(userinfo)
                        .role(string).build()).toList());
        userRepository.save(userinfo);
    }

}


