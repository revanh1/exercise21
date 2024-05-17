package org.abbtech.practice.lesson23_orm.tests;
import org.abbtech.practice.lesson23_orm.enums.*;
import org.abbtech.practice.lesson23_orm.annotations.Loggable;
import org.abbtech.practice.lesson23_orm.annotations.Secured;
import org.abbtech.practice.lesson23_orm.enums.*;
import org.springframework.stereotype.Component;

@Component
public class TestClass {
    @Secured({Role.ADMIN, Role.USER})
    public void securedMethod(Role role) {
        System.out.println("Inside securedMethod");
    }

    @Loggable(priority = Priority.HIGH)
    public void unsecuredMethod() {
        System.out.println("Inside loggable");
    }

}
