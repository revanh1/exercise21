package org.abbtech.practice.lesson23_orm.aspects;

import org.abbtech.practice.lesson23_orm.annotations.Secured;
import org.abbtech.practice.lesson23_orm.enums.Role;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class SecuredAspect {
    @Before("@annotation(secured) && args(role)")
    public void checkAuthorization(Secured secured, Role role) {
        Role[] allowedRoles = secured.value();

        boolean authorized = false;
        for (Role allowedRole : allowedRoles) {
            if (role == allowedRole) {
                authorized = true;
                break;
            }
        }
        if (authorized) {
            System.out.println("authorized");
//            log.info("Authorized");
        } else {
            System.out.println("not - authorized");
//            log.info("Not Authorized");
        }
    }
}
