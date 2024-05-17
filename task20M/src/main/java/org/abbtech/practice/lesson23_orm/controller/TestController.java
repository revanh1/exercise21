package org.abbtech.practice.lesson23_orm.controller;


import lombok.RequiredArgsConstructor;
import org.abbtech.practice.lesson23_orm.enums.*;
import org.abbtech.practice.lesson23_orm.tests.TestClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestClass testClass;
    @GetMapping("/secured/admin")
    public String securedAdmin() {
        testClass.securedMethod(Role.ADMIN);
        return "secured admin";
    }

    @GetMapping("/unsecured/admin")
    public String unsecuredAdmin() {
        testClass.unsecuredMethod();
        return "unsecured admin";
    }

    @GetMapping("/secured/user")
    public String securedUser() {
        testClass.securedMethod(Role.USER);
        return "secured user";
    }

}
