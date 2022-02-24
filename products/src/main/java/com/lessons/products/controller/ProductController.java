package com.lessons.products.controller;

import java.util.List;

import com.lessons.products.entity.Product;
import com.lessons.products.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/greet")
        public String greetMe() {
            return "Hello there";
        }

    @GetMapping("/")
        public List<Product> getAllProducts() {
             return productService.getProducts();
        }
    
    @PostMapping("/addProduct")
        public void addProduct(@RequestBody Product product) {
            productService.addProduct(product);
        }
    
    @GetMapping("/products/{id}")
        public Product getProductById(@PathVariable("id") Integer id) {
            return productService.getProductById(id);
        }

    @GetMapping("/getDepartment/{id}") 
        public String getDepartmentName(@PathVariable("id") Integer id) {
            return productService.getDepartmentById(id);
        }
}
