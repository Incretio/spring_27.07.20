package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.sample.dto.ProductDTO;
import ru.geekbrains.sample.services.ProductService;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/minPrice")
    public ProductDTO getProductWithMinPrice() {
        return productService.getProductWithMinPrice();
    }

    @GetMapping("/maxPrice")
    public ProductDTO getProductWithMaxPrice() {
        return productService.getProductWithMaxPrice();
    }

    @GetMapping
    public ProductDTO getProductByPrice(@RequestParam String filterByPrice) {
        if (filterByPrice.equalsIgnoreCase("max")) {
            return productService.getProductWithMaxPrice();
        } else {
            return productService.getProductWithMinPrice();
        }
    }

    @PostMapping
    public void saveOne(ProductDTO productDTO) {
        productService.save(productDTO);
    }

}