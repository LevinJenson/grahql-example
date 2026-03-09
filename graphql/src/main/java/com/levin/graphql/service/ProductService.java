package com.levin.graphql.service;

import com.levin.graphql.entity.Product;
import com.levin.graphql.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

   private final ProductRepository repository;

   @PostConstruct
   public void saveMasterData() {
      if (repository.count() > 0) return;

      repository.saveAll(List.of(
         new Product("iPhone 15 Pro",     "Electronics",  999.99f,  50),
         new Product("Samsung Galaxy S24", "Electronics",  849.99f,  75),
         new Product("Sony WH-1000XM5",   "Electronics",  349.99f, 120),
         new Product("Nike Air Max 270",  "Footwear",      129.99f, 200),
         new Product("Adidas Ultraboost", "Footwear",      179.99f, 150),
         new Product("Levi's 501 Jeans",  "Clothing",       69.99f, 300),
         new Product("The North Face Jacket", "Clothing",  249.99f,  80),
         new Product("Instant Pot Duo",   "Kitchen",        89.99f,  60),
         new Product("Dyson V15 Vacuum",  "Home",          649.99f,  40),
         new Product("LEGO Technic Set",  "Toys",           99.99f, 110)
      ));
   }


   public List<Product> getProductsByCategory(String category) {
      return repository.findByCategory(category);
   }

   public List<Product> getProducts() {
      return repository.findAll();
   }
}
