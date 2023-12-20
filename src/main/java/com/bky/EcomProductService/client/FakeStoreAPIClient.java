package com.bky.EcomProductService.client;

import com.bky.EcomProductService.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreAPIUrl;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreAPIPathProduct;
    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreAPIUrl) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIUrl = fakeStoreAPIUrl;
    }


    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){

        String createProductUrl = fakeStoreAPIUrl+fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(createProductUrl,fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();

    }

    public FakeStoreProductResponseDTO getProduct(int id){
        String getProductUrlId = fakeStoreAPIUrl+fakeStoreAPIPathProduct+"/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(getProductUrlId,FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String getAllProducts = fakeStoreAPIUrl+fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProducts,FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }

    public void deleteProduct(int id){
        String productDeleteURL = fakeStoreAPIUrl+fakeStoreAPIPathProduct+"/"+id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteURL);
    }





}
