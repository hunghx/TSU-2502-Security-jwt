package ra.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.dto.ProductAddDto;
import ra.edu.dto.ProductUpdateDto;
import ra.edu.entity.Product;
import ra.edu.exception.NotFoundException;
import ra.edu.service.IProductService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@ModelAttribute ProductAddDto request){
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED); // 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @ModelAttribute ProductUpdateDto request) throws NotFoundException {
        return new ResponseEntity<>(productService.updateProduct(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) throws NotFoundException {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
    }
}
