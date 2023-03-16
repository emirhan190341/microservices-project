package com.emirhanarici.productservice.service;

import com.emirhanarici.productservice.dto.request.ProductRequest;
import com.emirhanarici.productservice.dto.response.ProductResponse;
import com.emirhanarici.productservice.entity.Product;
import com.emirhanarici.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved.", product.getId());

        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }


    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream().map(each ->
                        ProductResponse.builder()
                                .id(each.getId())
                                .name(each.getName())
                                .description(each.getDescription())
                                .price(each.getPrice())
                                .build()).collect(Collectors.toList());

    }
}
