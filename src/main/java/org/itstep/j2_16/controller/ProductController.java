package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.Product;
import org.itstep.j2_16.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productServise;

    @Autowired
    public ProductController(ProductService productServise) {
        this.productServise = productServise;
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productServise.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable long id) {
        return new ResponseEntity<>(productServise.getById(id), OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productServise.save(product), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable long id, @RequestBody Product product) {
        return new ResponseEntity<>(productServise.update(id, product), OK);
    }
}
