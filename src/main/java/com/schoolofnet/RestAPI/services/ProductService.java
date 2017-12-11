package com.schoolofnet.RestAPI.services;

import com.schoolofnet.RestAPI.models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product findOne();
    public Product create(Product product);
    public Product update();
    public void delete();
}
