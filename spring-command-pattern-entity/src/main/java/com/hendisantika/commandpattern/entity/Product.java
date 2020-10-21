package com.hendisantika.commandpattern.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/10/20
 * Time: 19.42
 */
@Data
@Builder
@Document
public class Product {

    @Id
    private String id;

    private String name;

    private Long price;

    private Integer stock;
}
