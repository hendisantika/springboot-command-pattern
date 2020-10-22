package com.hendisantika.springcommandpatternvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/10/20
 * Time: 19.22
 */
@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {CartMustExistsValidator.class})
@Documented
public @interface CartMustExists {

    String message() default "CartMustExists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
