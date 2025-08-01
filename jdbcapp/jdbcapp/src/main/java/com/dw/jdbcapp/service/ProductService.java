package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.repository.ProductTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductTemplateRepository productTemplateRepository;

    public Product saveProduct(Product product) {
        return productTemplateRepository.saveProduct(product);
    }

    public Product updateProduct(Product product) {
        return productTemplateRepository.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productTemplateRepository.deleteProduct(id);
    }

    public List<Product> getProductByProductName(String name) {
        return productTemplateRepository.getProductByProductName(name);
    }
}
