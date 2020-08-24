package com.test.product.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.test.product.catalogue.entity.Product;

import java.util.List;

public interface ProductCatalogueRepository extends JpaRepository<Product, Long>{
	
	@Query("select products from Product products where products.productType = :productType")
	List<Product> findByProductType(@Param("productType") String productType);
	
	@Modifying
    @Transactional
    @Query("delete from Product products where products.id = :id ")
    int deleteById(@Param("id") Long id);

}
