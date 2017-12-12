package com.schoolofnet.RestAPI.services;

import com.schoolofnet.RestAPI.models.Product;
import com.schoolofnet.RestAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product create(Product product) {
        this.productRepository.save(product);
        return product;
    }

    @Override
    public Product update(Long id, Product product) {
        Product productExists = this.productRepository.findOne(id);
        if (productExists != null) {
            product.setId(productExists.getId());
            productRepository.save(product);
            return product;

        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Product product = this.productRepository.findOne(id);
        if (product != null) {
            productRepository.delete(id);
        }

    }
}
