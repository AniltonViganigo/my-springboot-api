package com.startspring.myfirst.repositories;

import com.startspring.myfirst.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
