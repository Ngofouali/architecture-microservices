package com.icodi.microservices.inventoryservice.config;

import com.icodi.microservices.inventoryservice.entities.Product;
import com.icodi.microservices.inventoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("===========================================");
        System.out.println(" Chargement des données de test produits...");
        System.out.println("===========================================");

        if (productRepository.count() > 0) {
            System.out.println(" Des produits existent déjà en base de données, fin de chargement");
            return;
        }

        // Création des produits avec Builder
        createProducts();

        System.out.println("=========================================================");
        System.out.println(productRepository.count() + " produits créés avec succès !");
        System.out.println("=========================================================");

    }

    private void createProducts() {

        Product laptop1 = Product.builder()
                .name("Dell XPS 15")
                .description("Ordinateur portable haute performance avec écran 15.6\" 4K, Intel i9, 32GB RAM, SSD 1TB")
                .sku("LAPTOP-DELL-XPS15-001")
                .price(new BigDecimal("900.000"))
                .quantityInStock(15)
                .minimumStockLevel(3)
                .category("Informatique")
                .build();
        productRepository.save(laptop1);
        System.out.println(laptop1.getName());

        Product laptop2 = Product.builder()
                .name("MacBook Pro 14\"")
                .description("MacBook Pro M3 Pro, 18GB RAM, SSD 512GB, écran Retina")
                .sku("LAPTOP-APPLE-MBP14-001")
                .price(new BigDecimal("2299.99"))
                .quantityInStock(8)
                .minimumStockLevel(2)
                .category("Informatique")
                .build();
        productRepository.save(laptop2);
        System.out.println(laptop2.getName());

        Product laptop3 = Product.builder()
                .name("HP Pavilion 17")
                .description("Ordinateur portable 17.3\", AMD Ryzen 7, 16GB RAM, SSD 512GB")
                .sku("LAPTOP-HP-PAV17-001")
                .price(new BigDecimal("899.99"))
                .quantityInStock(25)
                .minimumStockLevel(5)
                .category("Informatique")
                .build();
        productRepository.save(laptop3);
        System.out.println(laptop3.getName());

        Product desktop1 = Product.builder()
                .name("PC Gamer RTX 4080")
                .description("PC de bureau gaming : Intel i9, RTX 4080, 64GB RAM, SSD 2TB NVMe")
                .sku("DESKTOP-GAMING-RTX4080-001")
                .price(new BigDecimal("2499.99"))
                .quantityInStock(5)
                .minimumStockLevel(2)
                .category("Informatique")
                .build();
        productRepository.save(desktop1);
        System.out.println(desktop1.getName());

        Product monitor1 = Product.builder()
                .name("Samsung Odyssey G9 49\"")
                .description("Écran gaming incurvé 49\", 240Hz, QLED, 5120x1440")
                .sku("MONITOR-SAMSUNG-G9-001")
                .price(new BigDecimal("1299.99"))
                .quantityInStock(12)
                .minimumStockLevel(3)
                .category("Informatique")
                .build();
        productRepository.save(monitor1);
        System.out.println(monitor1.getName());

        Product keyboard1 = Product.builder()
                .name("Logitech MX Keys")
                .description("Clavier sans fil rétroéclairé pour professionnels")
                .sku("KEYBOARD-LOGITECH-MXKEYS-001")
                .price(new BigDecimal("119.99"))
                .quantityInStock(30)
                .minimumStockLevel(8)
                .category("Informatique")
                .build();
        productRepository.save(keyboard1);
        System.out.println(keyboard1.getName());

        Product mouse1 = Product.builder()
                .name("Logitech MX Master 3S")
                .description("Souris sans fil ergonomique haute précision")
                .sku("MOUSE-LOGITECH-MX3S-001")
                .price(new BigDecimal("99.99"))
                .quantityInStock(40)
                .minimumStockLevel(10)
                .category("Informatique")
                .build();
        productRepository.save(mouse1);
        System.out.println(mouse1.getName());

        Product phone1 = Product.builder()
                .name("iPhone 15 Pro Max")
                .description("iPhone 15 Pro Max 256GB, Titane Naturel, Apple A17 Pro")
                .sku("PHONE-APPLE-I15PM-001")
                .price(new BigDecimal("1479.99"))
                .quantityInStock(20)
                .minimumStockLevel(5)
                .category("Smartphone")
                .build();
        productRepository.save(phone1);
        System.out.println(phone1.getName());

        Product phone2 = Product.builder()
                .name("Samsung Galaxy S24 Ultra")
                .description("Galaxy S24 Ultra 512GB, Snapdragon 8 Gen 3, Caméra 200MP")
                .sku("PHONE-SAMSUNG-S24U-001")
                .price(new BigDecimal("1399.99"))
                .quantityInStock(18)
                .minimumStockLevel(4)
                .category("Smartphone")
                .build();
        productRepository.save(phone2);
        System.out.println(phone2.getName());

        Product phone3 = Product.builder()
                .name("Google Pixel 8 Pro")
                .description("Pixel 8 Pro 256GB, Tensor G3, Caméra IA avancée")
                .sku("PHONE-GOOGLE-P8P-001")
                .price(new BigDecimal("1099.99"))
                .quantityInStock(15)
                .minimumStockLevel(3)
                .category("Smartphone")
                .build();
        productRepository.save(phone3);
        System.out.println(phone3.getName());

        Product lowStock1 = Product.builder()
                .name("Webcam Logitech C920")
                .description("Webcam HD 1080p avec micro stéréo")
                .sku("WEBCAM-LOGITECH-C920-001")
                .price(new BigDecimal("79.99"))
                .quantityInStock(2)  // Stock bas !
                .minimumStockLevel(5)
                .category("Informatique")
                .build();
        productRepository.save(lowStock1);
        System.out.println("Produit créé (STOCK BAS) :" + lowStock1.getName());

        Product outOfStock1 = Product.builder()
                .name("Steam Deck 512GB")
                .description("Console portable PC gaming par Valve")
                .sku("GAMING-VALVE-STEAMDECK-512-001")
                .price(new BigDecimal("649.99"))
                .quantityInStock(0)  // Rupture de stock !
                .minimumStockLevel(3)
                .category("Gaming")
                .build();
        productRepository.save(outOfStock1);
        System.out.println("Produit créé (RUPTURE) :" + outOfStock1.getName());
    }
}
