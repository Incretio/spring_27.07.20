package ru.geekbrains.sample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.sample.dao.ProductRepository;
import ru.geekbrains.sample.dto.ProductDTO;
import ru.geekbrains.sample.persistence.entity.Product;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDTO getProductWithMinPrice() {
        return entityToDto(productRepository.findFirstByOrderByPriceAsc());
    }

    public ProductDTO getProductWithMaxPrice() {
        return entityToDto(productRepository.findFirstByOrderByPriceDesc());
    }

    public void save(ProductDTO productDTO) {
        productRepository.save(dtoToEntity(productDTO));
    }

    private ProductDTO entityToDto(Product product) {
        return ProductDTO.builder()
                         .name(product.getName())
                         .price(product.getPrice())
                         .build();
    }

    private Product dtoToEntity(ProductDTO productDTO) {
        return Product.builder()
                      .name(productDTO.getName())
                      .price(productDTO.getPrice())
                      .build();
    }
}
