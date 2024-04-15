package com.Myapp.Productservice_pratice.thirdPartyClients.Dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FakeStoreProductDto {
    private  Long id;
    private String Title;
    private  String description;
    private  String image;
    private String  category;
    private double Price;


}
