package com.Myapp.Productservice_pratice.thirdPartyClients;

import com.Myapp.Productservice_pratice.thirdPartyClients.Dtos.FakeStoreProductDto;
import com.Myapp.Productservice_pratice.DTos.GenericProductDto;
import com.Myapp.Productservice_pratice.Exception.NotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component

public class FakeStoreProductClint {

   // @Value("${fakestore.api.baseurl}")
   // private String fakeStoreApiBaseUrl;

   // @Value("${fakestore.api.product}")
    //private String fakeStoreProductPath;

    private RestTemplateBuilder restTemplateBuilder;
    private  String createproducturl= "https://fakestoreapi.com/products";
    private  String productUrl="https://fakestoreapi.com/products{id}";



    @Autowired
    public FakeStoreProductClint(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;
    }




    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(createproducturl, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();



        return Arrays.asList(fakeStoreProductDtos);
    }


    public FakeStoreProductDto getProductsById(Long id) throws NotFountException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(productUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if (fakeStoreProductDto == null) {
           // return null;
           throw new NotFountException("product with" + id + " not found");
        }

        return fakeStoreProductDto;
    }



    public FakeStoreProductDto createProduct(GenericProductDto product) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.postForEntity(createproducturl, product,
                        FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();


        return fakeStoreProductDto;
    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.exchange(productUrl, HttpMethod.DELETE,
                        null, FakeStoreProductDto.class, id);
        //null ,http entity bads me header add karna hoga to kar denge
        FakeStoreProductDto fakeStoreProductDto = response.getBody();



        return fakeStoreProductDto;
    }
}
