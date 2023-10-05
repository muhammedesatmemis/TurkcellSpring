package com.turkcell.spring.first.repositories;

import com.turkcell.spring.first.entities.Product;
import com.turkcell.spring.first.entities.dtos.ProductForListingDto1;
import com.turkcell.spring.first.entities.dtos.ProductForListingDto2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value="SELECT new " +
            "com.turkcell.spring.first.entities.dtos.ProductForListingDto1" +
            "(p.productId, p.productName, p.quantityPerUnit, p.unitPrice, p.unitsInStock, p.unitsOnOrder, p.discontinued) " +
            "FROM Product p")
    List<ProductForListingDto1> getForListing();

    @Query(value="SELECT new com.turkcell.spring.first.entities.dtos.ProductForListingDto2 (p.productId, p.productName, p.quantityPerUnit, p.unitPrice, p.unitsInStock, p.unitsOnOrder) FROM Product p  Where p.productId = :ProductId")
    List<ProductForListingDto2> getForIdListing(int ProductId);


}