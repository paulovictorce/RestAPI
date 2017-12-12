package com.schoolofnet.RestAPI.resources;

import com.schoolofnet.RestAPI.models.Product;
import com.schoolofnet.RestAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {


    @Autowired
    private ProductService productService;

    public ProductResource(ProductService productService) {
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
        return productService.findOne(id);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return this.productService.create(product);
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public Product update(@PathVariable(value = "id") Long id, @RequestBody Product product) {
        return this.productService.update(id, product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) {
        this.productService.delete(id);
    }
}
