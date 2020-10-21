package com.hendisantika.commandpattern.repository;

import com.hendisantika.commandpattern.entity.Cart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/10/20
 * Time: 19.45
 */
public interface CartRepository extends ReactiveMongoRepository<Cart, String> {
}
