package com.lessons.products.service;

import java.util.List;

import com.lessons.products.repository.IProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lessons.products.entity.Department;
import com.lessons.products.entity.Product;

@Service
public class ProductService {

@Autowired
private IProductRepository productRepository;

@Autowired
private RestTemplate restTemplate;

public List<Product> getProducts() {
    return productRepository.findAll();
}

public Product getProductById(Integer id) {
    return productRepository.findById(id).get();
}

public void addProduct(Product product) {
    productRepository.save(product);
}

public  void deleteProduct(Integer id) {
    productRepository.deleteById(id);
}
public String getDepartmentById(Integer id) {
    Department department =  restTemplate.getForObject("http://DEPARTMENTSERVICE/departments/"+String.valueOf(id), Department.class);
    return String.valueOf(department.getDepartmentId() + "::" + department.getDepartmentName() + "::" + department.getDepartmentCode());
}
}