package com.hendisantika.validation.validator;

import com.hendisantika.commandpattern.entity.Cart;
import com.hendisantika.commandpattern.entity.CartItem;
import com.hendisantika.commandpattern.entity.Product;
import com.hendisantika.commandpattern.repository.CartRepository;
import com.hendisantika.commandpattern.repository.ProductRepository;
import com.hendisantika.validation.ProductQuantityMustEnough;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/10/20
 * Time: 19.33
 */
@Component
public class ProductQuantityUpdateMustEnoughValidator implements
        ConstraintValidator<ProductQuantityMustEnough, ProductQuantityMustEnough.ProductQuantityUpdate> {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void initialize(ProductQuantityMustEnough constraintAnnotation) {

    }

    @Override
    public boolean isValid(ProductQuantityMustEnough.ProductQuantityUpdate value, ConstraintValidatorContext context) {
        if (value == null || value.getProductId() == null || value.getQuantity() == null) {
            return true;
        }

        Cart cart = cartRepository.findById(value.getCartId()).block();

        if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {
            return true;
        }

        Optional<CartItem> cartItemOptional = getCartItemByProductId(cart, value.getProductId());

        if (!cartItemOptional.isPresent()) {
            return true;
        }

        Product product = productRepository.findById(value.getProductId()).block();

        if (product == null) {
            return false;
        }

        if (product.getStock() < value.getQuantity()) {
            return false;
        }

        return product.getStock() >= (cartItemOptional.get().getQuantity() + value.getQuantity());
    }

    private Optional<CartItem> getCartItemByProductId(Cart cart, String productId) {
        return cart.getItems().stream()
                .filter(cartItem -> cartItem.getId().equals(productId))
                .findFirst();
    }
}