package com.dw.jdbcapp.service;

import com.dw.jdbcapp.mapper.ProductMapper;
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
    ProductMapper productMapper;

    public Product saveProduct(Product product) {
        productMapper.saveProduct(product);
        return product;
    }

    public Product updateProduct(Product product) {
        productMapper.updateProduct(product);
        return product;
    }

    public void deleteProduct(int id) {
        productMapper.deleteProduct(id);
    }

    public List<Product> getProductByProductName(String name) {
        return productMapper.getProductByProductName(name);
    }
}
