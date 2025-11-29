package com.icodi.microservices.inventoryservice.mapper;

import com.icodi.microservices.inventoryservice.dto.ProductDTO;
import com.icodi.microservices.inventoryservice.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

    /*@Mapping(target = "lowStock", expression = "java(product.isLowStock())")
    @Mapping(target = "isOutOfStock", expression = "java(product.isOutOfStock())")*/
    ProductDTO productToProductDTO(Product product);

    /*@Mapping(target = "lowStock", ignore = true)
    @Mapping(target = "isOutOfStock", ignore = true)*/
    Product productDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> productListToProductDTOList(List<Product> productList);

    // Mise à jour d'une entité avec les données du DTO
    void updateProductFromProductDTO(ProductDTO productDTO, @MappingTarget Product product);
}
