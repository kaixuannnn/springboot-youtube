package com.kaixuanlearn.productservice.service;


import com.kaixuanlearn.productservice.dto.ProductRequest;
import com.kaixuanlearn.productservice.dto.ProductResponse;
import com.kaixuanlearn.productservice.model.Product;
import com.kaixuanlearn.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    /** inject the product repository into product service **/
    private final ProductRepository productRepository;
/**    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
   }
 We can remove the line above as we already use the required Args Constuctor introduced by lombok
 **/
    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product" + product.getId() + "is saved");
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        /** Lambda Expression **/
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
