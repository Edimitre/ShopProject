package com.edi.MyShopProject;

import com.edi.MyShopProject.entity.Category;
import com.edi.MyShopProject.repositories.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyShopProjectApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void testCreateCategory(){

		Category category = new Category();
		category.setName("Shtepiake");


		Category categorySaved = categoryRepository.save(category);

		Assertions.assertThat(categorySaved.getId()).isGreaterThan(0);
	}

}
