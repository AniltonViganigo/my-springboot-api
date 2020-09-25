package com.startspring.myfirst.config;

import com.startspring.myfirst.entities.User;
import com.startspring.myfirst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;

// Classe para configurar e instanciar os usuários no database;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Laura Vinas", "laura@gmail.com", "88888-8888", "200116");
        User user2 = new User(null, "Sue Ellen Vinas", "sue@gmail.com", "77777-8888", "22220807");

        userRepository.saveAll(Arrays.asList(user1,user2));

    }
}