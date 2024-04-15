package com.Myapp.Productservice_pratice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity(name="orders")
public class Order extends BaseModel{
    @ManyToMany
    @JoinTable(
            name="product_order",
            joinColumns = @JoinColumn(name="orderId"),
            inverseJoinColumns = @JoinColumn(name="ProductId")

    )
    private List<Product> products;

}
