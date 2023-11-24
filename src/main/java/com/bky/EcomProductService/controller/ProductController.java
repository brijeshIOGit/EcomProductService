package com.bky.EcomProductService.controller;

import com.bky.EcomProductService.dto.ProductListResponseDTO;
import com.bky.EcomProductService.dto.ProductResponseDTO;
import com.bky.EcomProductService.model.Product;
import com.bky.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    ProductService productService;





    @GetMapping("/product")
    public ResponseEntity getAllProducts(){

        /** ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setCategory("Electronics");
        p1.setTitle("IPhone 15 pro");
        p1.setPrice(150000);
        p1.setImage("www.google.com/images/iphone");
        p1.setDescription("Premium phone");


        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setCategory("Electronics");
        p2.setTitle("Macbok pro");
        p2.setPrice(250000);
        p2.setImage("www.google.com/images/macbook");
        p2.setDescription("Premium Laptop");

        List<ProductResponseDTO> products = Arrays.asList(p1,p2);

        return ResponseEntity.ok(products);*/

        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);

    }

    @GetMapping("/product/1")
    public ResponseEntity getProductFromId(){

        ProductResponseDTO response = productService.getProductById(1);
        return ResponseEntity.ok(response);

    }

}
