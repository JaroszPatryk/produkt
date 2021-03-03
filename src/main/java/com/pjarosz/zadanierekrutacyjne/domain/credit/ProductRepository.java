package com.pjarosz.zadanierekrutacyjne.domain.credit;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findOne(Long id);

    List<Product> findAll();

    void create(Product product);

}
