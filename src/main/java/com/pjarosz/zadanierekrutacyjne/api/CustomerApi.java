package com.pjarosz.zadanierekrutacyjne.api;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Product;
import com.pjarosz.zadanierekrutacyjne.domain.credit.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class CustomerApi {

    private ProductService productService;

    @GetMapping
    public List<Product> getProduct() {
        return productService.getProduct();
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getOne(@PathVariable Long productId) {
        return productService.getProductById(productId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid Product product) {
        productService.createProduct(product);
    }


}
