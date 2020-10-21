package com.hendisantika.commandpattern.entity;

import lombok.Builder;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/10/20
 * Time: 19.40
 */
@Data
@Builder
public class CartItem {

    private String id;

    private String name;

    private Long price;

    private Integer quantity;

}
