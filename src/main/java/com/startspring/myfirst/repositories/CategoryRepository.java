package com.startspring.myfirst.repositories;

import com.startspring.myfirst.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
