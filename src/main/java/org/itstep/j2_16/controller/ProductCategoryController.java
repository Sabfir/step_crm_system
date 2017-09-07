package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.ProductCategory;
import org.itstep.j2_16.service.ProductCategoryService;
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
@RequestMapping("/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryServise;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryServise) {
        this.productCategoryServise = productCategoryServise;
    }

    @GetMapping
    public ResponseEntity<?> getAllProductCategories() {
        return new ResponseEntity<>(productCategoryServise.getAll(), OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getProductCategory(@PathVariable long id) {
        return new ResponseEntity<>(productCategoryServise.getById(id), OK);
    }

    @PostMapping
    public ResponseEntity<?> createProductCategory(@RequestBody ProductCategory productCategory) {
        return new ResponseEntity<>(productCategoryServise.save(productCategory), OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<?> updateProductCategory(@PathVariable long id,
                                                   @RequestBody ProductCategory productCategory) {
        return new ResponseEntity<>(productCategoryServise.update(id, productCategory), OK);
    }
}
