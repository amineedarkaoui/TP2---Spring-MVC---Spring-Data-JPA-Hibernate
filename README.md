# TP2 - Application de Gestion des Produits
## Spring MVC, Spring Data JPA, Hibernate, Thymeleaf et Spring Security

---

## 📋 Table des Matières
1. [Introduction](#introduction)
2. [Objectifs du Projet](#objectifs-du-projet)
3. [Technologies Utilisées](#technologies-utilisées)
4. [Configuration du Projet](#configuration-du-projet)
5. [Architecture de l'Application](#architecture-de-lapplication)
6. [Développement Étape par Étape](#développement-étape-par-étape)
7. [Fonctionnalités Implémentées](#fonctionnalités-implémentées)
8. [Extension : Gestion Patient-Médecin](#extension-gestion-patient-médecin)
9. [Tests et Validation](#tests-et-validation)
10. [Captures d'Écran](#captures-décran)
11. [Difficultés Rencontrées](#difficultés-rencontrées)
12. [Conclusion](#conclusion)

---

## 🎯 Introduction

> **[PLACEHOLDER - Décrivez brièvement le contexte du projet et son objectif principal]**

Exemple :
- Ce projet consiste à développer une application web JEE pour la gestion des produits...
- L'application permet aux utilisateurs de...

---

## 📌 Objectifs du Projet

Cette application Web JEE vise à créer un système complet de gestion de produits avec les fonctionnalités suivantes :

- ✅ Gestion CRUD des produits (Create, Read, Update, Delete)
- ✅ Interface utilisateur responsive avec Bootstrap et Thymeleaf
- ✅ Sécurisation avec Spring Security
- ✅ Validation des formulaires
- ✅ Recherche et filtrage des produits
- ✅ Extension avec gestion patients/médecins

**Vidéos de référence :**
- [Gestion Produits](https://www.youtube.com/watch?v=FHy7raIldgg)
- [Patient-Médecin Partie 1](https://www.youtube.com/watch?v=Kfv_7m8INlU)
- [Patient-Médecin Partie 2](https://www.youtube.com/watch?v=s6p2dE3qrsU)

---

## 🛠️ Technologies Utilisées

| Technologie | Version | Description |
|-------------|---------|-------------|
| Java | **[PLACEHOLDER]** | Langage de programmation |
| Spring Boot | **[PLACEHOLDER]** | Framework principal |
| Spring Data JPA | **[PLACEHOLDER]** | Couche de persistance |
| Hibernate | **[PLACEHOLDER]** | ORM |
| Thymeleaf | **[PLACEHOLDER]** | Moteur de templates |
| Spring Security | **[PLACEHOLDER]** | Sécurité |
| Spring Validation | **[PLACEHOLDER]** | Validation des données |
| H2 Database | **[PLACEHOLDER]** | Base de données en développement |
| MySQL | **[PLACEHOLDER]** | Base de données en production |
| Lombok | **[PLACEHOLDER]** | Réduction du code boilerplate |
| Bootstrap | **[PLACEHOLDER]** | Framework CSS |
| Maven | **[PLACEHOLDER]** | Gestion des dépendances |

---

## ⚙️ Configuration du Projet

### 🔹 Étape 1 : Création du Projet Spring Boot

#### Dépendances Maven

**[PLACEHOLDER - Listez les dépendances ajoutées dans pom.xml]**

```xml
<dependencies>
    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- [PLACEHOLDER - Ajoutez les autres dépendances ici] -->

</dependencies>
```

#### Configuration de l'application (`application.properties`)

**[PLACEHOLDER - Ajoutez votre configuration]**

```properties
# Configuration H2 Database
spring.datasource.url=[PLACEHOLDER]
spring.datasource.username=[PLACEHOLDER]
spring.datasource.password=[PLACEHOLDER]

# Configuration JPA/Hibernate
spring.jpa.hibernate.ddl-auto=[PLACEHOLDER]
spring.jpa.show-sql=[PLACEHOLDER]

# Configuration Thymeleaf
spring.thymeleaf.cache=[PLACEHOLDER]

# [PLACEHOLDER - Ajoutez d'autres configurations]
```

#### Commandes Maven

**[PLACEHOLDER - Décrivez les commandes utilisées]**

```bash
# Créer le projet
mvn spring-boot:run

# Compiler le projet
[PLACEHOLDER]

# Lancer les tests
[PLACEHOLDER]
```

---

## 🏗️ Architecture de l'Application

### Structure du Projet

**[PLACEHOLDER - Décrivez l'architecture de votre projet]**

```
src/main/java/ma/amine/gestion_produits/
├── entities/
│   └── [PLACEHOLDER - Listez vos entités]
├── repositories/
│   └── [PLACEHOLDER - Listez vos repositories]
├── services/
│   └── [PLACEHOLDER - Listez vos services]
├── controllers/
│   └── [PLACEHOLDER - Listez vos contrôleurs]
├── security/
│   └── [PLACEHOLDER - Classes de sécurité]
└── dto/
    └── [PLACEHOLDER - Data Transfer Objects]

src/main/resources/
├── templates/
│   └── [PLACEHOLDER - Vues Thymeleaf]
└── static/
    └── [PLACEHOLDER - Fichiers CSS/JS]
```

### Diagramme de Classes

**[PLACEHOLDER - Insérez un diagramme de classes ou décrivez les relations]**

---

## 🚀 Développement Étape par Étape

### 🔹 Étape 2 : Création de l'Entité JPA Product

**[PLACEHOLDER - Décrivez votre entité Product]**

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    // [PLACEHOLDER - Ajoutez les attributs]

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // [PLACEHOLDER - Autres champs]
}
```

#### Attributs de l'entité :

| Attribut | Type | Contraintes | Description |
|----------|------|-------------|-------------|
| id | Long | @Id, @GeneratedValue | **[PLACEHOLDER]** |
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

---

### 🔹 Étape 3 : Interface ProductRepository

**[PLACEHOLDER - Décrivez votre repository]**

```java
public interface ProductRepository extends JpaRepository<Product, Long> {
    // [PLACEHOLDER - Ajoutez les méthodes personnalisées]

    // Exemple: recherche par nom
    List<Product> findByNameContains(String keyword);
}
```

#### Méthodes personnalisées :

| Méthode | Description | Exemple d'utilisation |
|---------|-------------|----------------------|
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

---

### 🔹 Étape 4 : Tests de la Couche DAO

**[PLACEHOLDER - Décrivez vos tests]**

```java
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        // [PLACEHOLDER - Ajoutez votre code de test]
    }

    // [PLACEHOLDER - Autres tests]
}
```

#### Résultats des tests :

**[PLACEHOLDER - Ajoutez les résultats de vos tests (captures d'écran, logs, etc.)]**

---

### 🔹 Étape 5 : Désactivation de Spring Security (Temporaire)

**[PLACEHOLDER - Expliquez comment vous avez désactivé Spring Security pour les tests initiaux]**

```java
@Configuration
public class SecurityConfig {
    // [PLACEHOLDER - Configuration]
}
```

---

### 🔹 Étape 6 : Contrôleur Spring MVC et Vues Thymeleaf

#### 6.1 Contrôleur ProductController

**[PLACEHOLDER - Décrivez votre contrôleur]**

```java
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model) {
        // [PLACEHOLDER - Code]
        return "products";
    }

    // [PLACEHOLDER - Autres méthodes]
}
```

#### Endpoints implémentés :

| Endpoint | Méthode HTTP | Description | Vue retournée |
|----------|--------------|-------------|---------------|
| `/` | GET | **[PLACEHOLDER]** | **[PLACEHOLDER]** |
| `/delete` | GET/POST | **[PLACEHOLDER]** | **[PLACEHOLDER]** |
| `/add` | GET/POST | **[PLACEHOLDER]** | **[PLACEHOLDER]** |
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

#### 6.2 Templates Thymeleaf

**[PLACEHOLDER - Décrivez vos vues]**

##### Template de base (`template.html`)

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
    <!-- [PLACEHOLDER - Head section] -->
</head>
<body>
    <!-- [PLACEHOLDER - Navbar, content, footer] -->
</body>
</html>
```

##### Vue liste des produits (`products.html`)

**[PLACEHOLDER - Décrivez la vue]**

##### Vue d'ajout/modification (`editProduct.html`)

**[PLACEHOLDER - Décrivez la vue]**

#### 6.3 Validation des Formulaires

**[PLACEHOLDER - Expliquez les validations]**

| Champ | Règles de validation | Message d'erreur |
|-------|---------------------|------------------|
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

```java
public class Product {
    @NotBlank(message = "[PLACEHOLDER]")
    private String name;

    // [PLACEHOLDER - Autres validations]
}
```

---

### 🔹 Étape 7 : Sécurisation avec Spring Security

**[PLACEHOLDER - Décrivez votre configuration de sécurité]**

#### Configuration de sécurité

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // [PLACEHOLDER - Configuration]
        return http.build();
    }

    // [PLACEHOLDER - Autres beans]
}
```

#### Utilisateurs et Rôles

| Utilisateur | Mot de passe | Rôle | Permissions |
|-------------|--------------|------|-------------|
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

#### Règles d'autorisation

**[PLACEHOLDER - Décrivez les règles]**

| URL | Rôle requis | Description |
|-----|-------------|-------------|
| `/` | TOUS | **[PLACEHOLDER]** |
| `/admin/**` | ADMIN | **[PLACEHOLDER]** |
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

---

## ✨ Fonctionnalités Implémentées

### 🔹 Étape 8 : Fonctionnalités Supplémentaires

#### 8.1 Recherche de Produits

**[PLACEHOLDER - Décrivez la fonctionnalité de recherche]**

```java
@GetMapping("/search")
public String search(@RequestParam String keyword, Model model) {
    // [PLACEHOLDER - Code]
}
```

**Capture d'écran :** **[PLACEHOLDER - Ajoutez une capture d'écran]**

---

#### 8.2 Édition et Mise à Jour d'un Produit

**[PLACEHOLDER - Décrivez la fonctionnalité d'édition]**

```java
@GetMapping("/edit")
public String editProduct(@RequestParam Long id, Model model) {
    // [PLACEHOLDER - Code]
}

@PostMapping("/update")
public String updateProduct(@Valid Product product, BindingResult bindingResult) {
    // [PLACEHOLDER - Code]
}
```

**Capture d'écran :** **[PLACEHOLDER - Ajoutez une capture d'écran]**

---

#### 8.3 Autres Fonctionnalités

**[PLACEHOLDER - Listez et décrivez les autres fonctionnalités que vous avez ajoutées]**

1. **[PLACEHOLDER - Fonctionnalité 1]**
   - Description : **[PLACEHOLDER]**
   - Code : **[PLACEHOLDER]**

2. **[PLACEHOLDER - Fonctionnalité 2]**
   - Description : **[PLACEHOLDER]**
   - Code : **[PLACEHOLDER]**

---

## 🏥 Extension : Gestion Patient-Médecin

### 🔹 Étape 9 : Implémentation du Système Patient-Médecin-Rendez-vous

**[PLACEHOLDER - Décrivez l'extension de votre application]**

#### Entités créées :

##### Patient

```java
@Entity
@Data
public class Patient {
    // [PLACEHOLDER - Attributs]
}
```

##### Médecin

```java
@Entity
@Data
public class Medecin {
    // [PLACEHOLDER - Attributs]
}
```

##### Rendez-vous

```java
@Entity
@Data
public class RendezVous {
    // [PLACEHOLDER - Attributs]
}
```

##### Consultation

```java
@Entity
@Data
public class Consultation {
    // [PLACEHOLDER - Attributs]
}
```

##### User et Role

**[PLACEHOLDER - Décrivez la gestion des utilisateurs et rôles]**

#### Diagramme de Classes (Extension)

**[PLACEHOLDER - Ajoutez un diagramme]**

#### Relations entre Entités

| Entité 1 | Relation | Entité 2 | Description |
|----------|----------|----------|-------------|
| Patient | **[PLACEHOLDER]** | RendezVous | **[PLACEHOLDER]** |
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

#### Repositories

**[PLACEHOLDER - Listez les repositories créés]**

```java
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // [PLACEHOLDER - Méthodes]
}
```

#### Contrôleurs

**[PLACEHOLDER - Décrivez les contrôleurs]**

#### Vues Thymeleaf

**[PLACEHOLDER - Listez et décrivez les vues]**

---

## 🧪 Tests et Validation

### Tests Unitaires

**[PLACEHOLDER - Décrivez vos tests unitaires]**

| Test | Classe testée | Résultat |
|------|---------------|----------|
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | ✅/❌ |

### Tests d'Intégration

**[PLACEHOLDER - Décrivez vos tests d'intégration]**

### Tests Manuels

**[PLACEHOLDER - Décrivez les scénarios de tests manuels]**

| Scénario | Étapes | Résultat attendu | Résultat obtenu |
|----------|--------|------------------|-----------------|
| **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** | **[PLACEHOLDER]** |

---

## 📸 Captures d'Écran

### Page d'Accueil (Liste des Produits)

**[PLACEHOLDER - Insérez une capture d'écran]**

![Liste des produits](path/to/screenshot.png)

---

### Page d'Ajout de Produit

**[PLACEHOLDER - Insérez une capture d'écran]**

![Ajout produit](path/to/screenshot.png)

---

### Validation des Formulaires

**[PLACEHOLDER - Insérez une capture d'écran]**

![Validation](path/to/screenshot.png)

---

### Page de Recherche

**[PLACEHOLDER - Insérez une capture d'écran]**

![Recherche](path/to/screenshot.png)

---

### Page de Connexion (Spring Security)

**[PLACEHOLDER - Insérez une capture d'écran]**

![Login](path/to/screenshot.png)

---

### Interface Patient-Médecin

**[PLACEHOLDER - Insérez une capture d'écran]**

![Patient-Medecin](path/to/screenshot.png)

---

## 🔧 Base de Données

### Schéma de la Base de Données H2

**[PLACEHOLDER - Insérez une capture d'écran de la console H2]**

### Console H2

- **URL :** `http://localhost:8080/h2-console`
- **JDBC URL :** **[PLACEHOLDER]**
- **Username :** **[PLACEHOLDER]**
- **Password :** **[PLACEHOLDER]**

### Scripts SQL

**[PLACEHOLDER - Ajoutez les scripts SQL d'initialisation si nécessaires]**

```sql
-- [PLACEHOLDER - Scripts]
```

---

## ⚠️ Difficultés Rencontrées

### Difficulté 1 : **[PLACEHOLDER - Titre]**

**Description :** **[PLACEHOLDER - Décrivez le problème]**

**Solution :** **[PLACEHOLDER - Décrivez la solution]**

---

### Difficulté 2 : **[PLACEHOLDER - Titre]**

**Description :** **[PLACEHOLDER - Décrivez le problème]**

**Solution :** **[PLACEHOLDER - Décrivez la solution]**

---

### Difficulté 3 : **[PLACEHOLDER - Titre]**

**Description :** **[PLACEHOLDER - Décrivez le problème]**

**Solution :** **[PLACEHOLDER - Décrivez la solution]**

---

## 💡 Améliorations Possibles

**[PLACEHOLDER - Listez les améliorations que vous pourriez apporter]**

- [ ] **[PLACEHOLDER - Amélioration 1]**
- [ ] **[PLACEHOLDER - Amélioration 2]**
- [ ] **[PLACEHOLDER - Amélioration 3]**
- [ ] Ajouter des tests automatisés plus complets
- [ ] Implémenter une API REST
- [ ] Ajouter l'upload d'images pour les produits
- [ ] Mettre en place un système de pagination
- [ ] **[PLACEHOLDER]**

---

## 📝 Conclusion

**[PLACEHOLDER - Rédigez une conclusion]**

Points clés à mentionner :
- Ce que vous avez appris
- Les compétences acquises
- L'intérêt du projet
- Perspectives futures

---

## 📚 Ressources et Références

- [Documentation Spring Boot](https://spring.io/projects/spring-boot)
- [Documentation Spring Security](https://spring.io/projects/spring-security)
- [Documentation Thymeleaf](https://www.thymeleaf.org/)
- [Vidéo Gestion Produits](https://www.youtube.com/watch?v=FHy7raIldgg)
- [Vidéo Patient-Médecin Partie 1](https://www.youtube.com/watch?v=Kfv_7m8INlU)
- [Vidéo Patient-Médecin Partie 2](https://www.youtube.com/watch?v=s6p2dE3qrsU)
- **[PLACEHOLDER - Ajoutez d'autres ressources]**

---

## 👤 Informations sur l'Auteur

- **Nom :** **[PLACEHOLDER]**
- **Classe :** **[PLACEHOLDER]**
- **Date :** **[PLACEHOLDER]**
- **Encadrant :** **[PLACEHOLDER]**

---

## 📄 Licence

**[PLACEHOLDER - Si applicable]**

---

**Fin du Rapport**