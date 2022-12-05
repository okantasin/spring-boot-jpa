package com.springbootjpa.springbootjpa.repository;

import com.springbootjpa.springbootjpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMetod() {
        //create product
        Product product = new Product();
        product.setName("product1");
        product.setDescription("product1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");
        //save product
        Product savedObject = productRepository.save(product);
        //display product info
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());


    }

    @Test
    void updateUsingSaveMethod() {

        //find or rertieve an entity by id
        Long id = 10L;
        Product product = productRepository.findById(id).get();

        //update entity information

        product.setName("updated product1");
        product.setDescription("update product1 desc");

        //save updated entity
        productRepository.save(product);

    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod() {

        //CREATED PRODUCT
        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("product2 description");
        product2.setSku("100ABCD");
        product2.setPrice(new BigDecimal(100));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        //CREATED PRODUCT
        Product product3 = new Product();
        product3.setName("product3");
        product3.setDescription("product3 description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal(100));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        //CREATED PRODUCT
        Product product4 = new Product();
        product4.setName("product4");
        product4.setDescription("product4 description");
        product4.setSku("100ABCDEF");
        product4.setPrice(new BigDecimal(100));
        product4.setActive(true);
        product4.setImageUrl("product4.png");

        productRepository.saveAll(List.of(product2, product3, product4));

    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();
        products.forEach((product -> System.out.println(product.getName())));
    }

    @Test
    void deleteByIdMethod() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        //find an entity by id
        Long id = 5L;
        Product product = productRepository.findById(id).get();
        //delete(entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethods() {

        Product product = productRepository.findById(8L).get();

        Product product1 = productRepository.findById(9L).get();

        productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void existsByIdMethod() {
        Long id = 7L;

        boolean result = productRepository.existsById(id);

        System.out.println(result);
    }

    @Test
    void countMethod() {
        long count = productRepository.count();
        System.out.println(count);
    }
}

