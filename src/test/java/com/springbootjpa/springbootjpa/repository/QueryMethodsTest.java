package com.springbootjpa.springbootjpa.repository;


import com.springbootjpa.springbootjpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product3");
        System.out.println(product.getName());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(10L).get();
        System.out.println(product.getName());

    }
    @Test
    void findByNameOrDescriptionMethod(){
       List<Product>  product = productRepository.findByNameOrDescription("product3","product3 description");
       product.forEach((p)->{
           System.out.println(p.getId());
           System.out.println(p.getName());
       });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product>  product = productRepository.findByNameAndDescription("product3","product3 description");
        product.forEach((p)->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("product3");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(50));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(120));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByNameContainingMethod(){
        List<Product> products =productRepository.findByNameContaining("product3");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("product 1");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(100), new BigDecimal(300)
        );
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        LocalDateTime startDate = LocalDateTime.of(2022,12,04,23,49,23);
        LocalDateTime endDate = LocalDateTime.of(2022,12,05,23,49,23);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate,endDate);
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameInMethod(){

        List<Product> products = productRepository.findByNameIn(List.of("product 1", "product 2", "product 3"));
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findTop2ByOrderByPriceDescMethod(){
        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
