package com.in28minutes.springboot.myfirstwebapp.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productRepository extends JpaRepository<products, Integer> {

}
