package com.edi.MyShopProject.repositories;

import com.edi.MyShopProject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
