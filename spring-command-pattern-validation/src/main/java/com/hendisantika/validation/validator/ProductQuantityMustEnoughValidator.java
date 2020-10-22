package com.hendisantika.validation.validator;

import com.hendisantika.commandpattern.entity.Product;
import com.hendisantika.commandpattern.repository.ProductRepository;
import com.hendisantika.validation.ProductQuantityMustEnough;
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
 * Time: 19.32
 */
@Component
public class ProductQuantityMustEnoughValidator implements
        ConstraintValidator<ProductQuantityMustEnough, ProductQuantityMustEnough.ProductQuantity> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void initialize(ProductQuantityMustEnough constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductQuantityMustEnough.ProductQuantity value, ConstraintValidatorContext context) {
        if (value == null || value.getProductId() == null || value.getQuantity() == null) {
            return true;
        }

        Product product = productRepository.findById(value.getProductId()).block();

        if (isProductNotExists(product)) {
            return true;
        }

        return isStockEnough(product, value.getQuantity());
    }

    private boolean isProductNotExists(Product product) {
        return product == null;
    }

    private boolean isStockEnough(Product product, Integer quantity) {
        return product.getStock() >= quantity;
    }
}