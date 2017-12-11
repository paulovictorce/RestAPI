package com.schoolofnet.RestAPI.resources;

import com.schoolofnet.RestAPI.models.Product;
import com.schoolofnet.RestAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {


    @Autowired
    private ProductService productService;

    public ProductResource (ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    @ResponseBody
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Product find(@PathVariable(value = "id") Long id) {
        return null;
    }

    @PostMapping
    @ResponseBody
    public Product create(@RequestBody Product product) {
        return this.productService.create(product);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public Product update(@PathVariable(value = "id")Long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id")Long id) {

    }
}
