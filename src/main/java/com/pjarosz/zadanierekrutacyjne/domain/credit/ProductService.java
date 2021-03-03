package com.pjarosz.zadanierekrutacyjne.domain.credit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.create(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findOne(id);
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }
}
