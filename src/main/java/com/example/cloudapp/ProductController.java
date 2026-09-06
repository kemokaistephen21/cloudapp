package com.example.cloudapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// This controller handles the product pages and CRUD operations.
@Controller
public class ProductController 
{

    private final ProductRepository productRepository;

    // This connects the controller to the product repository.
    public ProductController(ProductRepository productRepository) 
    {
        this.productRepository = productRepository;
    }

 // This displays the home page.
    @GetMapping("/")
    public String showHomePage() 
    {
        return "index";
    }
    
    // This displays all products.
    @GetMapping("/products")
    public String showProducts(Model model) 
    {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    // This displays the form for adding a product.
    @GetMapping("/products/new")
    public String showAddProduct(Model model) 
    {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    // This saves a new product or updates an existing product.
    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product) 
    {
        productRepository.save(product);
        return "redirect:/products";
    }

    // This displays the form for editing a product.
    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) 
    {
        Product product = productRepository.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "product-form";
    }

    // This deletes a product.
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) 
    {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
