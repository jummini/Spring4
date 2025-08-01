package com.dw.jdbcapp.mapper;

import com.dw.jdbcapp.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void saveProduct(@Param("product") Product product);
    void updateProduct(@Param("product") Product product);
    void deleteProduct(@Param("id") int id);
    List<Product> getProductByProductName(@Param("name") String name);
}
