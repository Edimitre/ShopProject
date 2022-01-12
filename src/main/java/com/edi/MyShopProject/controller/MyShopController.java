package com.edi.MyShopProject.controller;

import com.edi.MyShopProject.entity.Category;
import com.edi.MyShopProject.entity.Product;
import com.edi.MyShopProject.repositories.CategoryRepository;
import com.edi.MyShopProject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@Controller
public class MyShopController {

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ProductRepository productRepository;


    @GetMapping("")
    public String homePage(){

        return "index";
    }

    @GetMapping("/categories")
    public String showAllCategories(Model model){

        List<Category> categoryList = categoryRepository.findAll();

        model.addAttribute("categoryList", categoryList);
        return "categories";
    }

    @GetMapping("/category/new")
    public String showAddCategoryForm(Model model){

        model.addAttribute("category", new Category());
        return "category_form";
    }

    @PostMapping("/category/save")
    public String saveCategory(Category category){
        categoryRepository.save(category);

        return "redirect:/categories";
    }

    @GetMapping("/products")
    public String showAllProducts(Model model){

        List<Product> productList = productRepository.findAll();

        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/products/new")
    public String showAddProductForm(Model model){

        List<Category> categoryList = categoryRepository.findAll();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/product/save")
    public String saveProduct(Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/product/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model){

        Product product = productRepository.findById(id).get();

        List<Category> categoryList = categoryRepository.findAll();

        model.addAttribute("categoryList", categoryList);

        model.addAttribute("product", product);
        return "product_form";
    }

    // ketu fshijme produktin
    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){

        Product product = productRepository.findById(id).get();

        productRepository.delete(product);


        return "redirect:/products";
    }
}
