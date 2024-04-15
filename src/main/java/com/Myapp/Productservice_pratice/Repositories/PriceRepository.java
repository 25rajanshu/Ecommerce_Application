package com.Myapp.Productservice_pratice.Repositories;

import com.Myapp.Productservice_pratice.Models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}
