package com.hendisantika.commandpattern.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

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
}