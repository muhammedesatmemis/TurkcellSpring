package com.turkcell.spring.first.business.concretes;

import com.turkcell.spring.first.business.abstracts.ProductService;
import com.turkcell.spring.first.business.exceptions.BusinessException;
import com.turkcell.spring.first.entities.Product;
import com.turkcell.spring.first.entities.dtos.*;

import com.turkcell.spring.first.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        Product product = getProductById(productId);
        if (product != null) {
            productRepository.delete(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product product1 = getProductById(productId);
        if (product1 != null) {
            product1.setProductName(product.getProductName());
            product1.setUnitPrice(product.getUnitPrice());
            productRepository.save(product1);
            return product1;
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<ProductForListingDto2> getByIdDto(int productId) {
        return productRepository.getForIdListing(productId);

    }

    @Override
    public List<ProductForListingDto1> getAllProducts() {
        return productRepository.getForListing();
    }

    public void addProductToDto(ProductForAddDto request) {
        addProductPriceShouldNotBeNegative(request.getUnitPrice());

        addProductUnitPriceControl(request);

        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setQuantityPerUnit(request.getQuantityPerUnit());
        product.setUnitPrice(request.getUnitPrice());
        product.setDiscontinued(0);
    }

    public Product updateProductDto(int productId, ProductForUpdate product){
        updateProductIsNotFoundId(product.getProductId());

        Product product1 = getProductById(productId);
        if (product1 != null) {
            product1.setProductName(product.getProductName());
            product1.setUnitPrice(product.getUnitPrice());
            productRepository.save(product1);
            return product1;
        } else {
            throw new RuntimeException("Product not found");
        }
    }
    private void addProductUnitPriceControl(ProductForAddDto request) {
        if (request.getUnitPrice() > 50) {
            throw new BusinessException("Ürün fiyatı 50'den büyük olamaz.");
        }
    }


////    public void deleteProduct(int productId) {
////        Product product = getProductById(productId);
//        if (product != null) {
//            productRepository.delete(product);
//        } else {
//            throw new RuntimeException("Product not found");
//        }
////    }


    public void deleteProductDto(int productId){
        ProductForDeleteDto productForDeleteDto = new ProductForDeleteDto();
        productForDeleteDto.setProductId(productId);
        Product product = getProductById(productForDeleteDto.getProductId());
        if (product != null) {
            productRepository.delete(product);
        } else {
            throw new RuntimeException("Product not found");
        }


    }
    private void updateProductIsNotFoundId(int productId) {
        Optional<Product> IsExistProduct = productRepository.findById(productId);
        if (IsExistProduct == null) {
            throw new BusinessException("Bu Id de güncellenecek ürün bulunamadı.");
        }
    }

    private void addProductPriceShouldNotBeNegative(double unitPrice) {
        if (unitPrice < 0) {
            throw new BusinessException("Ürün fiyatı negatif olamaz.");
        }
    }
}
