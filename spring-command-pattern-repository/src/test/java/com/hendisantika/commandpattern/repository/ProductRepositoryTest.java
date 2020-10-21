package com.hendisantika.commandpattern.repository;

import com.hendisantika.commandpattern.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/10/20
 * Time: 20.06
 */
@SpringBootTest
@DirtiesContext
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveProduct() throws Exception {
        Product product = Product.builder()
                .id("id")
                .name("name")
                .price(1000L)
                .stock(1000)
                .build();

        Product result = productRepository.save(product).block();

        assertEquals(result, product);
    }

    @Test
    public void testSaveAndGetProduct() throws Exception {
        Product product = Product.builder()
                .id("id")
                .name("name")
                .price(1000L)
                .stock(1000)
                .build();

        productRepository.save(product).block();
        Product result = productRepository.findById("id").block();

        assertEquals(result, product);
    }
}