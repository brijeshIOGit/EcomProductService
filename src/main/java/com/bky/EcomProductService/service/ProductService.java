package com.bky.EcomProductService.service;

import com.bky.EcomProductService.dto.ProductListResponseDTO;
import com.bky.EcomProductService.dto.ProductResponseDTO;
import com.bky.EcomProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    ProductListResponseDTO getAllProducts();

    ProductResponseDTO getProductById(int id);
    Product createProduct(Product product);
    Product deleteProduct(int id);

    Product updateProduct(int id, Product updatedProduct);
}
