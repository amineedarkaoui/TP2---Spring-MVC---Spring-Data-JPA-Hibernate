package ma.amine.gestion_produits.service;

import lombok.RequiredArgsConstructor;
import ma.amine.gestion_produits.entity.Product;
import ma.amine.gestion_produits.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
