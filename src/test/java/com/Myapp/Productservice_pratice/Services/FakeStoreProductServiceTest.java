package com.Myapp.Productservice_pratice.Services;



import com.Myapp.Productservice_pratice.DTos.GenericProductDto;
import com.Myapp.Productservice_pratice.Exception.NotFountException;
import com.Myapp.Productservice_pratice.thirdPartyClients.FakeStoreProductClint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FakeStoreProductServiceTest {

    @Autowired
    private FakeStroreProductService fakeStoreProductService;

    @MockBean
    private FakeStoreProductClint fakeStoreProductClient;

    //    @Test
    public void testGetProductByIdWhenClientReturnsNull() throws NotFountException {
        when(fakeStoreProductClient.getProductsById(any()))
                .thenReturn(null);

        GenericProductDto response = fakeStoreProductService.getProductsById(1L);

        Assertions.assertNull(response);

        Assertions.assertThrows(ChangeSetPersister.NotFoundException.class,
                () -> fakeStoreProductService.getProductsById(1L));
    }
}
