package com.Myapp.Productservice_pratice.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@Entity

public class Product extends BaseModel{
    private String Title;
    private  String description;
    private  String image;
    @ManyToOne
    @JoinColumn(name="category")
    private Category category;
    @OneToOne(cascade= {CascadeType.REMOVE})
  //  @OneToOne(cascade= {CascadeType.REMOVE,CascadeType.PERSIST}) if you are not saving
    //this price to db still first inset price then product
    private Price price;
}
