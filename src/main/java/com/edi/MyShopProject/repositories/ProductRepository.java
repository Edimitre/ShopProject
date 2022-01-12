package com.edi.MyShopProject.repositories;

import com.edi.MyShopProject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
