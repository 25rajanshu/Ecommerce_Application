package com.Myapp.Productservice_pratice.DTos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class GenericProductDto {
    private  Long id;
    private String Title;
    private  String description;
    private  String image;
    private String  category;
    private double Price;

}
