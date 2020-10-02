package com.startspring.myfirst.config;

import com.startspring.myfirst.entities.Category;
import com.startspring.myfirst.entities.Order;
import com.startspring.myfirst.entities.Product;
import com.startspring.myfirst.entities.User;
import com.startspring.myfirst.enums.OrderStatus;
import com.startspring.myfirst.repositories.CategoryRepository;
import com.startspring.myfirst.repositories.OrderRepository;
import com.startspring.myfirst.repositories.ProductRepository;
import com.startspring.myfirst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        Product p6 = new Product(null, "Teste", "Testando", 1222.00, "");

        categoryRepository.saveAll(Arrays.asList(category1,category2,category3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));

        User user1 = new User(null, "Laura Vinas", "laura@gmail.com", "88888-8888", "200116");
        User user2 = new User(null, "Sue Ellen Vinas", "sue@gmail.com", "77777-8888", "22220807");

        userRepository.saveAll(Arrays.asList(user1,user2));

        Order o1 = new Order(null, Instant.parse("2020-07-20T20:57:09Z"), OrderStatus.PAID, user1);
        Order o2 = new Order(null, Instant.parse("2020-07-20T20:57:09Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2020-07-20T20:57:09Z"), OrderStatus.DELIVERED, user1);


        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
