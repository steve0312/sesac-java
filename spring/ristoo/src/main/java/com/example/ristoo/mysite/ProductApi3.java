package com.example.ristoo.mysite;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v3/products")
public class ProductApi3 {
    private List<Product> products = new ArrayList<>();
    private Long id = 0L;

    {
        products.add(new Product(++id, "초기 상품명", 0));
    }


    // create- 상품 생성
    // 내용 / url
    // "/posts", method : POST
    @PostMapping
    public Product createProduct() {
        Product product = new Product(++id, "상품명", 1000);
        products.add(product);

        return product;
    }


    // read- 전체 상품 조회
    // "/posts", method : GET
    @GetMapping
    public List<Product> readProducts() {
        return products;
    }

    // read- 특정 상품 조회
    // id
    // "/posts/{id}, method : GET
    @GetMapping("/{id}")
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
    // "/posts/{id}", method : PUT
    @PutMapping("/{id}")
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
    // "/posts/{id}", method : DELETE
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        Product removedProduct = null;

        for (Product product : products) {
            if(product.getId().equals(id)) {
                removedProduct = product;
                break;
            }
        }
        products.remove(removedProduct);

        return null;
    }
}
