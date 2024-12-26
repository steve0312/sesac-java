package com.example.ristoo.mysite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductApi2 {
    private List<Product> products = new ArrayList<>();
    private Long id = 0L;

    {
        products.add(new Product(++id, "초기 상품명", 0));
    }


    // create- 상품 생성
    // 내용 / url
//    @GetMapping("/products/create")
    @PostMapping("/v2/products")
    public Product createProduct() {
        Product product = new Product(++id, "상품명", 1000);
        products.add(product);

        return product;
    }


    // read- 전체 상품 조회
    @GetMapping("/v2/products")
    public List<Product> readProducts() {
        return products;
    }

    // read- 특정 상품 조회
    // id
    @GetMapping("/v2/products/{id}")
    public Product readProductsById(@PathVariable Long id) {
        for (Product product : products) {
            if(product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }


    // update- 특정 상품 수정
    // id
//    @GetMapping("/v2/products/{id}/update")
    @PutMapping("/v2/products/{id}")
    public Product updateProduct(@PathVariable Long id) {
        for (Product product : products) {
            if(product.getId().equals(id)) {
                product.setProductName("음료수");
                product.setProductPrice(1500);

                return product;
            }
        }
        return null;
    }


    // delete- 특정 상품 삭제
    // id
//    @GetMapping("/products/{id}/delete")
    @DeleteMapping("/v2/products/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        for (Product product : products) {
            if(product.getId().equals(id)) {
                products.remove(product);
            }
        }
        return null;
    }
}
