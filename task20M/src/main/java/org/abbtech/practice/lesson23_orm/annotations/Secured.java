package org.abbtech.practice.lesson23_orm.annotations;

import org.abbtech.practice.lesson23_orm.enums.Role;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Secured {
    Role[] value();

}
