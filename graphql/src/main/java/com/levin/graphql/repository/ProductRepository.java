package com.levin.graphql.repository;

import com.levin.graphql.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
   List<Product> findByCategory(String category);
}
