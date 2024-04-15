package com.Myapp.Productservice_pratice;
import com.Myapp.Productservice_pratice.Models.Category;
import com.Myapp.Productservice_pratice.Models.Price;
import com.Myapp.Productservice_pratice.Models.Product;
import com.Myapp.Productservice_pratice.Repositories.CategoryRepository;
import com.Myapp.Productservice_pratice.Repositories.PriceRepository;
import com.Myapp.Productservice_pratice.Repositories.ProductRepository;
import com.Myapp.Productservice_pratice.inheritanceExample.singletable.MentorRepository;
import com.Myapp.Productservice_pratice.inheritanceExample.tableperclass.Studentrepository;
import com.Myapp.Productservice_pratice.inheritanceExample.tableperclass.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ProductservicePraticeApplication  implements CommandLineRunner{
    private MentorRepository mentorRepository;
private Studentrepository studentrepository;
private UserRepository userRepository;
private CategoryRepository categoryRepository;
private PriceRepository priceRepository;
private ProductRepository productRepository;

@Autowired
    public ProductservicePraticeApplication(MentorRepository mentorRepository,
                                            UserRepository userRepository,
                                            Studentrepository studentrepository,
                                            CategoryRepository categoryRepository,
                                            PriceRepository priceRepository,
                                            ProductRepository productRepository) {
        this.mentorRepository = mentorRepository;
        this.userRepository=userRepository;
        this.studentrepository= studentrepository;
        this.categoryRepository=categoryRepository;
        this.priceRepository=priceRepository;
        this.productRepository=productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductservicePraticeApplication.class, args);
    }

    public void run(String... args) throws Exception {
       /* Mentor mentor = new Mentor();
        mentor.setName("Vikranth");
        mentor.setEmail("v@gmail.com");
        mentor.setAvgRating(100.0);
        this.mentorRepository.save(mentor);*/
        Category category = new Category();
        category.setName("electronics");
        Category savedcategory = categoryRepository.save(category);
        Price price = new Price("Rupee",10.0);
        Price savedPrice = priceRepository.save(price);
        Product product = new Product();
        product.setCategory(savedcategory);
        product.setImage("image.url");
        product.setDescription("Best price ever");
        product.setPrice(savedPrice);
       productRepository.save(product);


    }
}
