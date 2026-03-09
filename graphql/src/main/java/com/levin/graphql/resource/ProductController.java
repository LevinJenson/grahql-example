package com.levin.graphql.resource;

import com.levin.graphql.entity.Product;
import com.levin.graphql.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

   private final ProductService service;

   @QueryMapping
   public List<Product> getProducts() {
      return service.getProducts();
   }

   @QueryMapping
   public List<Product> getProductsByCategory(@Argument String category) {
      return service.getProductsByCategory(category);
   }

}
