package com.Myapp.Productservice_pratice.Repositories;

import com.Myapp.Productservice_pratice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
