package ru.geekbrains.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.sample.persistence.entity.Product;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findFirstByOrderByPriceAsc();
    Product findFirstByOrderByPriceDesc();
}