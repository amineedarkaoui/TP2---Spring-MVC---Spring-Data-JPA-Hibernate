package ma.amine.gestion_produits;

import ma.amine.gestion_produits.entity.Product;
import ma.amine.gestion_produits.repository.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GestionProduitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionProduitsApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("TV")
                    .price(500.0)
                    .build()
            );
            productRepository.save(Product.builder()
                    .name("Hello")
                    .price(500.0)
                    .build()
            );
            productRepository.save(Product.builder()
                    .name("World")
                    .price(500.0)
                    .build()
            );

            productRepository.findAll().forEach(p -> System.out.println(p));
        };
    }
}
