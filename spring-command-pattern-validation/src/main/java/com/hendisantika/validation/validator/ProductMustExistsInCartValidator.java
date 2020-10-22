package com.hendisantika.validation.validator;

import com.hendisantika.commandpattern.entity.Cart;
import com.hendisantika.commandpattern.repository.CartRepository;
import com.hendisantika.validation.ProductMustExistsInCart;
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
 * Time: 19.30
 */
@Component
public class ProductMustExistsInCartValidator implements ConstraintValidator<ProductMustExistsInCart,
        ProductMustExistsInCart.ProductInCart> {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void initialize(ProductMustExistsInCart constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductMustExistsInCart.ProductInCart value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Cart cart = cartRepository.findById(value.getCartId()).block();
        if (cart == null) {
            return true;
        }

        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            return false;
        }

        return cart.getItems().stream()
                .anyMatch(cartItem -> cartItem.getId().equals(value.getProductId()));
    }
}
