package ma.amine.gestion_produits.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.amine.gestion_produits.entity.Product;
import ma.amine.gestion_produits.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/new-product")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @PostMapping("/new-product/add")
    public String addProduct(@ModelAttribute @Valid Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }
}
