package com.hendisantika.commandpattern.repository;

import com.hendisantika.commandpattern.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/10/20
 * Time: 20.05
 */
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
