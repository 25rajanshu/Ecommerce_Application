package com.Myapp.Productservice_pratice.thirdpartyclients;




import com.Myapp.Productservice_pratice.Exception.NotFountException;
import com.Myapp.Productservice_pratice.thirdPartyClients.Dtos.FakeStoreProductDto;
import com.Myapp.Productservice_pratice.thirdPartyClients.FakeStoreProductClint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductClientTest {
    @Autowired
    private FakeStoreProductClint fakeStoreProductClient;

    @MockBean
    private RestTemplateBuilder restTemplateBuilder;

//    @MockBean
//    private RestTemplate restTemplate;

    //    @Test
    public void testGetProductById() throws NotFountException {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        when(restTemplateBuilder.build())
                .thenReturn(restTemplate);

        ResponseEntity<FakeStoreProductDto> responseMock =
                new ResponseEntity<>(null, HttpStatus.OK);

        when(restTemplate.getForEntity(any(String.class), eq(FakeStoreProductDto.class), any(Long.class)))
                .thenReturn(responseMock);

        FakeStoreProductDto response = fakeStoreProductClient.getProductsById(1L);

        Assertions.assertNull(response);

    }
}
