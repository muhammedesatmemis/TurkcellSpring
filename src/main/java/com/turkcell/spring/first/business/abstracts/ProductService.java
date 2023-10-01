package com.turkcell.spring.first.business.abstracts;

import com.turkcell.spring.first.entities.Product;
import com.turkcell.spring.first.entities.dtos.ProductForAddDto;
import com.turkcell.spring.first.entities.dtos.ProductForListingDto1;
import com.turkcell.spring.first.entities.dtos.ProductForListingDto2;
import com.turkcell.spring.first.entities.dtos.ProductForUpdate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void addProduct(Product product);

    void deleteProduct(int productId);
    Product updateProduct(int productId, Product product);

    Product getProductById(int productId);
    List<ProductForListingDto1> getAllProducts();
    List<ProductForListingDto2> getByIdDto(int productId);

    void addProductToDto(ProductForAddDto request);
    Product updateProductDto(int productId, ProductForUpdate product);

    void deleteProductDto(int productId);
}
