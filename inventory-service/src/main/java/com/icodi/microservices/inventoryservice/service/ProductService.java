package com.icodi.microservices.inventoryservice.service;

import com.icodi.microservices.inventoryservice.dto.ProductDTO;
import com.icodi.microservices.inventoryservice.entities.Product;
import com.icodi.microservices.inventoryservice.exception.ProductNotFoundException;
import com.icodi.microservices.inventoryservice.mapper.ProductMapper;
import com.icodi.microservices.inventoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public List<ProductDTO> getAllProducts() {
        System.out.println("Récupération de tous les products");
        List<Product> products = productRepository.findAll();
        System.out.println(products.size() + " produits trouvés");
        return productMapper.productListToProductDTOList(products);
    }

    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {
        System.out.println("Récupération du produit avec l'ID :" + id);
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return productMapper.productToProductDTO(product);
    }

    @Transactional(readOnly = true)
    public ProductDTO getProductBySku(String sku) {
        System.out.println("Récupération du produit avec le SKU " + sku);
        Product product = productRepository.findBysku(sku)
                .orElseThrow(()-> new ProductNotFoundException("Produit avec le SKU " + sku + " Introuvable"));
        return productMapper.productToProductDTO(product);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        System.out.println("Création d'un nouveau produit : " + productDTO.getSku());

        if (productRepository.existsBySku(productDTO.getSku())){
            throw new IllegalArgumentException(
                    "Un produit avec ce SKU existe déjà : " + productDTO.getSku()
            );
        }

        Product product = productMapper.productDTOToProduct(productDTO);
        Product savedProduct = productRepository.save(product);

        System.out.println("Produit avec l'ID : " + savedProduct.getId() + " créé avec succès.");
        return productMapper.productToProductDTO(savedProduct);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        System.out.println("Mise à jour du produit avec l'ID : " + id);

        Product existingProduct = productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException(id));

        if (!existingProduct.getSku().equals(productDTO.getSku()) &&
                productRepository.existsBySku(productDTO.getSku())){
                throw new IllegalArgumentException(
                        "Un autre produit utilise déjà ce SKU : " + productDTO.getSku()
                );
        }

        productMapper.updateProductFromProductDTO(productDTO, existingProduct);
        Product updatedProduct = productRepository.save(existingProduct);

        System.out.println("Produit avec l'ID : " + updatedProduct.getId() + "mis à jour avec succès.");
        return productMapper.productToProductDTO(updatedProduct);
    }

    public void deleteProduct(Long id) {
        System.out.println("Suppression du produit avec l'ID : " + id);

        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }
        productRepository.deleteById(id);
        System.out.println("Produit avec l'ID : " + id + "supprimé avec succès.");
    }

    /*
    * Ajuste la quantité en stock d'un produit
    *  quantityChange peut être positif (ajout) ou négatif (retrait)
    * **/
    public ProductDTO adjustStock(Long id, Integer quantityChange) {
        System.out.println("Ajustement du stock du produit avec l'ID : " + id
                + " et pour quantité : " + quantityChange);

        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));

        int newQuantity = product.getQuantityInStock() + quantityChange;

        if(newQuantity < 0){
            throw new IllegalArgumentException(
                    "Stock insuffisant. Stock actuel : " + product.getQuantityInStock() +
                            "tentative de retrait : " + Math.abs(newQuantity)
            );
        }

        product.setQuantityInStock(newQuantity);
        Product updatedProduct = productRepository.save(product);

        System.out.println("Stock ajusté avec succès. Nouveau stock : " + newQuantity);

        if (updatedProduct.isLowStock()){
            System.out.println("ALERTE : Le produit " + updatedProduct.getName()
                    + " est en stock bas ("+ newQuantity +" unités)");
        }
        return productMapper.productToProductDTO(updatedProduct);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getLowStockProducts() {
        System.out.println("Récupération des produits en stock bas");
        List<Product> products = productRepository.findLowStockProducts();
        System.out.println(products.size() + " produits en stock bas");
        return productMapper.productListToProductDTOList(products);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getOutOfStockProducts() {
        System.out.println("Récupération des produits en rupture de stock");
        List<Product> products = productRepository.findOutOfStockProducts();
        System.out.println(products.size() + " produits en rupture de stock");
        return productMapper.productListToProductDTOList(products);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> searchProducts(String searchTerm) {
        System.out.println("recherche de produits avec le terme : " + searchTerm);
        List<Product> products = productRepository.searchProducts(searchTerm);
        System.out.println(products.size() + " produits trouvés avec le terme : " + searchTerm);
        return productMapper.productListToProductDTOList(products);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getProductByCategory(String category) {
        System.out.println("Récupération des produits de la catégorie : " + category);
        List<Product> products = productRepository.findByCategory(category);
        System.out.println(products.size() + " produits trouvés dans la catégorir: " + category);
        return productMapper.productListToProductDTOList(products);
    }
}
