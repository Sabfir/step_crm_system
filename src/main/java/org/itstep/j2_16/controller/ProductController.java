package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.Product;
import org.itstep.j2_16.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/product")

// GET - getAll - /clients -
// POST
// PUT
// DELETE

public class ProductController {
    private final ProductService productServise;

    @Autowired
    public ProductController(ProductService productServise) {
        this.productServise = productServise;
    }

    @GetMapping
    public ResponseEntity<?> getProduct() {
        return new ResponseEntity<>(productServise.getAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByIdProduct(@PathVariable long id){
        return new ResponseEntity<>(productServise.getById(id), OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productServise.save(product), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductCategories(@PathVariable long id, @RequestBody Product product) {
        return new ResponseEntity<>(productServise.update(id, product), OK);
    }
}
