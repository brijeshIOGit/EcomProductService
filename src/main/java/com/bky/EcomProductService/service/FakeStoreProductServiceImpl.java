package com.bky.EcomProductService.service;

import com.bky.EcomProductService.dto.ProductListResponseDTO;
import com.bky.EcomProductService.dto.ProductResponseDTO;
import com.bky.EcomProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {

        String getAllProductUrl = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<ProductListResponseDTO> productResponse = restTemplate.getForEntity(getAllProductUrl,ProductListResponseDTO.class);


        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String getAllProductUrl = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(getAllProductUrl,ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(int id) {
        return null;
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        return null;
    }
}
