package com.icodi.microservices.inventoryservice.controller;

import com.icodi.microservices.inventoryservice.dto.ProductDTO;
import com.icodi.microservices.inventoryservice.entities.Product;
import com.icodi.microservices.inventoryservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        System.out.println("Récupération de tous les products");
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        System.out.println("Récupération du produit " + id);
        ProductDTO productDTO = productService.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("sku/{sku}")
    public ResponseEntity<ProductDTO> getProductBySku(@PathVariable String sku) {
        System.out.println("Récupéraation du produit " + sku);
        ProductDTO product = productService.getProductBySku(sku);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        System.out.println("Création d'un produit");
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new  ResponseEntity<>(createdProduct, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        System.out.println("Mise a jour du produit " + id);
        System.out.println("Body reçu" + productDTO);
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(updatedProduct);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProductById(@PathVariable Long id) {
        System.out.println("Suppression du produit " + id);
        productService.deleteProduct(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Produit supprimé avec succès");
        response.put("id", id.toString());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/adjust-stock")
    public ResponseEntity<ProductDTO> adjustStock(@PathVariable Long id,
                                                  @RequestParam Integer quantity) {
        ProductDTO product = productService.adjustStock(id, quantity);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductDTO>> getLowStockProducts() {
        List<ProductDTO> products = productService.getLowStockProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/out-of-stock")
    public ResponseEntity<List<ProductDTO>> getOutOfStockProducts() {
        List<ProductDTO> products = productService.getOutOfStockProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam String term) {
        List<ProductDTO> products = productService.searchProducts(term);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(
            @PathVariable String category) {
        List<ProductDTO> products = productService.getProductByCategory(category);
        return ResponseEntity.ok(products);
    }
}
