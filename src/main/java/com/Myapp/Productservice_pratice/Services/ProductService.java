package com.Myapp.Productservice_pratice.Services;

import com.Myapp.Productservice_pratice.DTos.GenericProductDto;
import com.Myapp.Productservice_pratice.Exception.NotFountException;

import java.util.List;

public interface ProductService {
    public List<GenericProductDto> getAllProducts();
    public GenericProductDto getProductsById(Long id) throws NotFountException;
    public GenericProductDto createProduct(GenericProductDto genericProductDto);
    public GenericProductDto deleteProduct(Long id);

}
