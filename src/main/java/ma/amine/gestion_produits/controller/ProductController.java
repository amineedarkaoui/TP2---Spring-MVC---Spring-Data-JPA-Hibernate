package ma.amine.gestion_produits.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.amine.gestion_produits.entity.Product;
import ma.amine.gestion_produits.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String listProducts(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("products", productService.searchProducts(search));

        return "products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/new-product")
    public String productForm(
            Model model,
            @RequestParam(value = "id", required = false) Long id
    ) {
        if (id != null) {
            model.addAttribute("product", productService.getProductById(id));
        } else {
            model.addAttribute("product", new Product());
        }
        return "new_product";
    }

    @PostMapping("/new-product")
    public String addProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "new_product";
        }
        productService.addProduct(product);
        return "redirect:/";
    }
}
