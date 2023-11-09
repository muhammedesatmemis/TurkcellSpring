package com.turkcell.productservice.services;

import com.turkcell.productservice.dto.requests.CreateProductRequest;
import com.turkcell.productservice.dto.responses.CreatedProductResponse;
import com.turkcell.productservice.entities.Product;
import com.turkcell.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public CreatedProductResponse add(CreateProductRequest request) {
        Product product = Product
                .builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .stock(request.getStock())
                .inventoryCode(request.getInventoryCode())
                .build();

        product = productRepository.save(product);

        CreatedProductResponse response = CreatedProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .build();
        return response;
    }

    @Override
    public Boolean getByInventoryCode(String code, int requiredStock) {
        Product product = productRepository.findByInventoryCodeQuery(code);
        if(product==null || product.getStock() < requiredStock)
            return false;
        return true;
    }

    @Override
    public int getStockByCode(String code) {
        Product product = productRepository.findByInventoryCodeQuery(code);
        if(product==null)
            return 0;
        return product.getStock();

    }
}
