package ra.edu.service;

import ra.edu.dto.ProductAddDto;
import ra.edu.dto.ProductUpdateDto;
import ra.edu.entity.Product;
import ra.edu.exception.NotFoundException;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Integer id) throws NotFoundException;
    Product createProduct(ProductAddDto request);
    Product updateProduct(Integer id, ProductUpdateDto request) throws NotFoundException;
    void deleteProduct(Integer id) throws NotFoundException;
}
