package com.Myapp.Productservice_pratice.Services;

import com.Myapp.Productservice_pratice.thirdPartyClients.Dtos.FakeStoreProductDto;
import com.Myapp.Productservice_pratice.DTos.GenericProductDto;
import com.Myapp.Productservice_pratice.Exception.NotFountException;
import com.Myapp.Productservice_pratice.thirdPartyClients.FakeStoreProductClint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Primary
@Service("fakestoreproductservice")


public class FakeStroreProductService implements ProductService{

   private  FakeStoreProductClint fakeStoreProductClint;
    @Autowired
    public FakeStroreProductService(FakeStoreProductClint fakeStoreProductClint){
        this.fakeStoreProductClint= fakeStoreProductClint;
    }
    public GenericProductDto  convertFakeStoreDtoToGenericProductDto
            (FakeStoreProductDto fakeStoreProductDto){
        if(fakeStoreProductDto==null){
            return null;
        }
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        return genericProductDto;
    }
    @Override
    public List<GenericProductDto> getAllProducts() {
    List<FakeStoreProductDto> fakeStoreProductDtos=
            fakeStoreProductClint.getAllProducts();
    List<GenericProductDto> genericProductDtos = new ArrayList<>();
    for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
       GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(
               fakeStoreProductDto);
       genericProductDtos.add(genericProductDto);
    }


    return  genericProductDtos;

    }

    @Override
    public GenericProductDto getProductsById(Long id) throws NotFountException {


          return convertFakeStoreDtoToGenericProductDto
                  (fakeStoreProductClint.getProductsById(id));

    }



    @Override
    public GenericProductDto createProduct(GenericProductDto product) {




        return convertFakeStoreDtoToGenericProductDto
                (fakeStoreProductClint.createProduct(product));


    }

    @Override
    public GenericProductDto deleteProduct(Long id) {




              return convertFakeStoreDtoToGenericProductDto
                      (fakeStoreProductClint.deleteProduct(id));




    }
}
