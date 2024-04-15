package com.Myapp.Productservice_pratice.Services;

import com.Myapp.Productservice_pratice.DTos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selfproductservice")

public class SelfProductService implements ProductService{
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto getProductsById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
