package com.hendisantika.validation.validator;

import com.hendisantika.commandpattern.repository.CartRepository;
import com.hendisantika.validation.CartMustNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/10/20
 * Time: 19.27
 */
@Component
public class CartMustNotExistsValidator implements ConstraintValidator<CartMustNotExists, String> {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void initialize(CartMustNotExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return cartRepository.existsById(value).block() == Boolean.FALSE;
    }
}