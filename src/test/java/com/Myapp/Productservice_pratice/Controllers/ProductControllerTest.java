package com.Myapp.Productservice_pratice.Controllers;

import com.Myapp.Productservice_pratice.DTos.GenericProductDto;
import com.Myapp.Productservice_pratice.Exception.NotFountException;
import com.Myapp.Productservice_pratice.Services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//@SpringBootTest
public class ProductControllerTest {
   // @Autowired
    private ProductController productController;
   //@MockBean
    private ProductService productServiceMock;

   public ProductControllerTest(){
       productServiceMock= Mockito.mock(ProductService.class);
       productController= new ProductController(productServiceMock);
    }





    @Test
    public void TestGetProductByIdreturnEmptyObjectWhenNoProductIsFound() throws NotFountException {
        when(productServiceMock.getProductsById((long) 1L)).thenReturn(null);
    //    when(productServiceMock.getProductsById((any()).thenReturn(null);
     GenericProductDto response = productController.getProductById(1L);
     Assertions.assertNotNull(response);
    }

    @Test
    public void testMathOperation(){
      int result=add(2,4);
     // assert(result==6);
       // Assertions.assertEquals(6,result,"some failure happen");
        Assertions.assertThrows(NullPointerException.class,()->call());
    }
    private  int add(int a, int b ){
        return a+b-1;
        //return a+b+1;
    }
    public void call(){
        throw  new NullPointerException();
    }
    @Test
    public void testGetProductByIdreturnCorrectResponse() throws NotFountException {
      /*  GenericProductDto expectedoutput = new GenericProductDto();
        expectedoutput.setId(1L);
        expectedoutput.setTitle("Iphone");*/

        GenericProductDto tobeReturn = new GenericProductDto();
        tobeReturn.setId(1L);
      tobeReturn.setTitle("Iphone");
        when(productServiceMock.getProductsById(any())).thenReturn(tobeReturn);

        GenericProductDto response = productController.getProductById(1L);
      //  Assertions.assertEquals(response.getId(),expectedoutput.getId());
      //  Assertions.assertEquals(response.getTitle(),expectedoutput.getTitle());

        Assertions.assertEquals(response.getId(),1L);
          Assertions.assertEquals(response.getTitle(),"Iphone");

    }

}
