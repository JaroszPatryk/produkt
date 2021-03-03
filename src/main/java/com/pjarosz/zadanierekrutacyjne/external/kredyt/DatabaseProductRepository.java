package com.pjarosz.zadanierekrutacyjne.external.kredyt;

import com.pjarosz.zadanierekrutacyjne.domain.credit.Product;
import com.pjarosz.zadanierekrutacyjne.domain.credit.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DatabaseProductRepository implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    @Override
    public Optional<Product> findOne(Long id) {
        return jpaProductRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll()
                .stream().map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void create(Product product) {
        jpaProductRepository.save(toEntity(product));
    }

    private Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .nameProduct(entity.getNameProduct())
                .valueProduct(entity.getValueProduct())
                .build();
    }

    private ProductEntity toEntity(Product customer) {
        return ProductEntity.builder()
                .id(customer.getId())
                .nameProduct(customer.getNameProduct())
                .valueProduct(customer.getValueProduct())
                .build();
    }
}
