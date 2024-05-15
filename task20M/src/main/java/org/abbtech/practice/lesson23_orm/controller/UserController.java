package org.abbtech.practice.lesson23_orm.controller;

import org.abbtech.practice.lesson23_orm.dto.*;
import org.abbtech.practice.lesson23_orm.model.UserInfo;
import org.abbtech.practice.lesson23_orm.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserInfo> createUser(@RequestBody UserDTO user) {
        UserInfo createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
