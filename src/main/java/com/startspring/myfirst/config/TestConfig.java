package com.startspring.myfirst.config;

import com.startspring.myfirst.entities.Category;
import com.startspring.myfirst.entities.Order;
import com.startspring.myfirst.entities.User;
import com.startspring.myfirst.enums.OrderStatus;
import com.startspring.myfirst.repositories.CategoryRepository;
import com.startspring.myfirst.repositories.OrderRepository;
import com.startspring.myfirst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

// Classe para configurar e instanciar os usuários no database;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Laura Vinas", "laura@gmail.com", "88888-8888", "200116");
        User user2 = new User(null, "Sue Ellen Vinas", "sue@gmail.com", "77777-8888", "22220807");

        Order o1 = new Order(null, Instant.parse("2020-07-20T20:57:09Z"), OrderStatus.PAID, user1);
        Order o2 = new Order(null, Instant.parse("2020-07-20T20:57:09Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2020-07-20T20:57:09Z"), OrderStatus.DELIVERED, user1);

        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(category1,category2,category3));
        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
