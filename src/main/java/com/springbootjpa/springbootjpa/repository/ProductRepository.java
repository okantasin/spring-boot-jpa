package com.springbootjpa.springbootjpa.repository;

import com.springbootjpa.springbootjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
