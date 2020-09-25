package com.startspring.myfirst.repositories;

import com.startspring.myfirst.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
