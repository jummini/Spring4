package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    // POST 요청 (새로운 제품 1개를 추가)
    // URL: POST /api/product/post
    // Body: Product
    @PostMapping("/post")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // PUT 요청 (제품테이블의 정보를 수정)
    // URL: PUT /api/product/put
    // Body: Product
    @PutMapping("/put")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    // DELETE 요청 (제품테이블의 정보를 삭제)
    // URL: DELETE /api/product/delete?id=80
    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.deleteProduct(id);
        return "제품번호 " + id + " 삭제됨.";
    }

    // GET 요청 (제품명의 일부를 매개변수로 해당 문자열을 포함하는 제품들을 조회)
    // URL: GET /api/product/name/{name}
    @GetMapping("/name/{name}")
    public List<Product> getProductByProductName(
                            @PathVariable String name) {
        return productService.getProductByProductName(name);
    }
}
