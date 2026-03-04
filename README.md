# Rapport TP2 : Gestion des Produits avec Spring Boot

Ce fichier contient les réponses aux instructions pour la création de l'application Web JEE de gestion de produits.

## Objectif
Créer une application Web JEE basée sur Spring, Spring Data JPA, Hibernate, Thymeleaf et Spring Security pour gérer des produits.

---
**Prenom:** Amine\
**nom:** EDARKAOUI\
**Filliere:** II-BDCC 2
---

## 1. Créer un projet Spring Boot avec les dépendances

Le projet a été initialisé via Spring Initializr avec les dépendances suivantes dans le fichier `pom.xml` :

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

---

## 2. Créer l'entité JPA Product

Fichier : `src/main/java/ma/amine/gestion_produits/entity/Product.java`

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Price cannot be negative")
    @NotNull(message = "Price cannot be null")
    private Double price;

    @Min(value = 1, message = "Quantity cannot be lower than 1")
    @NotNull(message = "Quantity cannot be null")
    private Integer quantity;
}
```

---

## 3. Créer l'interface ProductRepository

Fichier : `src/main/java/ma/amine/gestion_produits/repository/ProductRepository.java`

```java
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContains(String name);
}
```

---

## 4. Tester la couche DAO

Le test de la couche DAO a été effectué initialement via un `CommandLineRunner` pour insérer des données de test au démarrage de l'application.

Fichier : `src/main/java/ma/amine/gestion_produits/GestionProduitsApplication.java`

```java
@Bean
CommandLineRunner commandLineRunner(ProductRepository productRepository){
    return args -> {
        productRepository.save(new Product(null, "Computer", 4300.0, 3));
        productRepository.save(new Product(null, "Printer", 1200.0, 4));
        productRepository.save(new Product(null, "SmartPhone", 3200.0, 32));

        productRepository.findAll().forEach(p -> {
            System.out.println(p.getName());
        });
    };
}
```

---

## 5. Désactiver la protection par défaut de Spring Security

Pour désactiver la sécurité par défaut (avant de configurer notre propre sécurité), on peut exclure la classe de configuration automatique dans l'annotation principale.

```java
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class GestionProduitsApplication { ... }
```

---

## 6. Créer le contrôleur Spring MVC et les vues Thymeleaf

### Contrôleur
Fichier : `src/main/java/ma/amine/gestion_produits/controller/ProductController.java`

```java
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
    public String productForm(Model model, @RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            model.addAttribute("product", productService.getProductById(id));
        } else {
            model.addAttribute("product", new Product());
        }
        return "new_product";
    }

    @PostMapping("/new-product")
    public String addProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "new_product";
        productService.addProduct(product);
        return "redirect:/";
    }
}
```

### Vue pour la liste (products.html)
Affiche la table des produits et inclut Bootstrap.

```html
<table class="table">
    <tr th:each="p : ${products}">
        <td th:text="${p.id}"></td>
        <td th:text="${p.name}"></td>
        <td th:text="${p.price}"></td>
        <td th:text="${p.quantity}"></td>
        <td><a class="btn btn-outline-primary" th:href="@{/new-product(id=${p.id})}">Edit</a></td>
        <td><a class="btn btn-danger" th:href="@{/delete(id=${p.id})}">Delete</a></td>
    </tr>
</table>
```

### Vue pour le formulaire (new_product.html)
Gère l'ajout et l'édition avec validation.

```html
<form method="post" th:action="@{/new-product}" th:object="${product}">
    <div>
        <label>Name</label>
        <input type="text" th:field="*{name}">
        <span th:errors="*{name}"></span>
    </div>
    <!-- Autres champs... -->
    <input type="hidden" th:field="*{id}" />
    <button type="submit">Save</button>
</form>
```

---

## 7. Sécuriser l'application avec Spring Security

Configuration d'une stratégie de sécurité personnalisée avec un utilisateur en mémoire ("admin").

Fichier : `src/main/java/ma/amine/gestion_produits/auth/SecurityConfig.java`

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
            User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("USER").build()
        );
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .formLogin(Customizer.withDefaults())
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
            .build();
    }
}
```

---

## 8. Ajouter d'autres fonctionnalités supplémentaires

### Recherche des produits
Implémentée dans le repository via `findByNameContains` et utilisée dans le contrôleur.

```java
// ProductRepository.java
List<Product> findByNameContains(String name);

// ProductService.java
public List<Product> searchProducts(String search) {
    search = search == null ? "" : search;
    return productRepository.findByNameContains(search);
}
```

### Édition et mise à jour
Le formulaire `new_product.html` est réutilisé. Si un paramètre `id` est passé dans l'URL (`/new-product?id=1`), le contrôleur charge le produit existant dans le modèle.

```java
// ProductController.java
if (id != null) {
    model.addAttribute("product", productService.getProductById(id));
}
```
L'input caché `<input type="hidden" th:field="*{id}" />` assure que l'ID est renvoyé lors de la soumission, déclenchant une mise à jour (update) au lieu d'une création (insert) par `productRepository.save()`.
