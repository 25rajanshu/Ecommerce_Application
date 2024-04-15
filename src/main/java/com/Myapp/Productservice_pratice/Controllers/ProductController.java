package com.Myapp.Productservice_pratice.Controllers;

import com.Myapp.Productservice_pratice.DTos.ExceptionDto;
import com.Myapp.Productservice_pratice.DTos.GenericProductDto;
import com.Myapp.Productservice_pratice.Exception.NotFountException;
import com.Myapp.Productservice_pratice.Services.FakeStroreProductService;
import com.Myapp.Productservice_pratice.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {


    private ProductService productService;
   @Autowired
    public  ProductController( ProductService productService){
         this.productService=productService;
    }

     @GetMapping
    public List<GenericProductDto> getAllProducts(){
          return  productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public  GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFountException {
     System.out.println("calling method");
        System.out.println("calling method again");
      GenericProductDto genericProductDto=   productService.getProductsById(id);
      if(genericProductDto==null){
          return  new GenericProductDto();
      }

      else
      return genericProductDto;
    }


    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        productService.createProduct(genericProductDto);
     return productService.createProduct(genericProductDto);

    }
    @DeleteMapping("/{id}")
    public  GenericProductDto deleteProduct(@PathVariable("id") Long id){
       return productService.deleteProduct(id);
    }
    //this annotation will be called if particular exception is thrown
    //in that controllewr

   //@ControllerAdvice
    @ExceptionHandler(NotFountException.class)
    public ResponseEntity<ExceptionDto> handleNotFountException
            (NotFountException notFountException){
       return  new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND,
               notFountException.getMessage()),HttpStatus.NOT_FOUND);
    }


}
