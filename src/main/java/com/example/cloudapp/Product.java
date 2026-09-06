package com.example.cloudapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// This class represents a product in our database
@Entity
public class Product {

    // This gives each product a unique ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // These variables store the product information
    private String name;
    private String description;
    private double price;
    private int quantity;

    // This empty constructor is needed by JPA
    public Product() {
    }

    // This constructor creates a product with its information
    public Product(String name, String description, double price, int quantity) 
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // These methods get and set the product information
    public Long getId() 
    {
        return id;
    }
    
 // This method keeps the product ID when updating a product.
    public void setId(Long id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }
}
