package org.itstep.j2_16.controller;

import org.itstep.j2_16.entity.ProductCategory;
import org.itstep.j2_16.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryServise;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryServise) {
        this.productCategoryServise = productCategoryServise;
    }

    @GetMapping
    public ResponseEntity<?> getProductCategories() {
        return new ResponseEntity<>(productCategoryServise.getAll(), OK);
    }

    @PostMapping
    public ResponseEntity<?> createProductCategories(@RequestBody ProductCategory productCategory) {
        return new ResponseEntity<>(productCategoryServise.save(productCategory), OK);
    }
}
