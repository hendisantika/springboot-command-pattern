package com.hendisantika.validation.validator;

import com.hendisantika.commandpattern.entity.Product;
import com.hendisantika.commandpattern.repository.ProductRepository;
import com.hendisantika.validation.ProductMustExists;
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
 * Time: 19.29
 */
@Component
public class ProductMustExistsValidator implements ConstraintValidator<ProductMustExists, String> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductMustExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Product product = productRepository.findById(value).block();
        return product != null;
    }
}
