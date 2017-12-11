package services;

import com.schoolofnet.RestAPI.models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public Product find(Long id);
    public Product create(Product product);
    public Product update(Long id, Product product);
    public void delete(Long id);
}