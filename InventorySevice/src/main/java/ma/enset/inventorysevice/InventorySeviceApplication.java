package ma.enset.inventorysevice;

import ma.enset.inventorysevice.entities.Product;
import ma.enset.inventorysevice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventorySeviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorySeviceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"Computer",8000,12));
            productRepository.save(new Product(null,"Printer",2000,5));
            productRepository.save(new Product(null,"Smartphone",3000,20));
            productRepository.findAll().forEach(System.out::println);
        };
    }
}
