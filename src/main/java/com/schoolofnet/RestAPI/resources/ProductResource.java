package com.schoolofnet.RestAPI.resources;

import com.schoolofnet.RestAPI.models.Product;
import com.schoolofnet.RestAPI.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> findAll() {

        List<Product> list =  this.productService.findAll();
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> find(@PathVariable(value = "id") Long id) {

        Product product = productService.findOne(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> create(@Valid @RequestBody Product product, Errors errors) {
        if (!errors.hasErrors()) {
            Product productCreated = this.productService.create(product);
            return new ResponseEntity<Product>(productCreated, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().body(
                errors.getAllErrors()
                        .stream()
                        .map(msg -> msg.getDefaultMessage())
                        .collect(Collectors.joining(", "))
        );
    }

    @PutMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Product product, Errors errors) {
        if (!errors.hasErrors()) {
            Product productUpdated = this.productService.update(id, product);
            return new ResponseEntity<Product>(productUpdated, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body(
                errors.getAllErrors()
                        .stream()
                        .map(msg -> msg.getDefaultMessage())
                        .collect(Collectors.joining(" ,"))
        );
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") Long id) {
        this.productService.delete(id);
    }
}
