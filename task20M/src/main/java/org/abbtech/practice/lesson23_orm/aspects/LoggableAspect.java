package org.abbtech.practice.lesson23_orm.aspects;

import org.abbtech.practice.lesson23_orm.annotations.Loggable;
import org.abbtech.practice.lesson23_orm.enums.Priority;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggableAspect {
    @Before("@annotation(loggable)")
    public void logBeforeMethod(Loggable loggable) {
        Priority priority = loggable.priority();
        System.out.println("Priority: " + priority);
    }

}
