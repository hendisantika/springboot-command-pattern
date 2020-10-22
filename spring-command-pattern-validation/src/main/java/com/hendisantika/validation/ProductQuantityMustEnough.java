package com.hendisantika.validation;

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
 * Time: 19.31
 */
@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {
        ProductQuantityMustEnoughValidator.class,
        ProductQuantityUpdateMustEnoughValidator.class
})
@Documented
public @interface ProductQuantityMustEnough {

    String message() default "ProductQuantityMustEnough";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};

    interface ProductQuantity {

        String getProductId();

        Integer getQuantity();

    }

    interface ProductQuantityUpdate {

        String getCartId();

        String getProductId();

        Integer getQuantity();

    }
}
