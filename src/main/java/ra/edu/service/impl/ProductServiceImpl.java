package ra.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.dto.ProductAddDto;
import ra.edu.dto.ProductUpdateDto;
import ra.edu.entity.Product;
import ra.edu.exception.NotFoundException;
import ra.edu.repository.IProductRepository;
import ra.edu.service.IProductService;
import ra.edu.service.UploadUtils;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private UploadUtils uploadUtils;
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) throws NotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product with " + id + " not found"));
    }

    @Override
    public Product createProduct(ProductAddDto request) {
        Product entity = new Product();
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setSku(request.getSku());
        entity.setCategoryName(request.getCategoryName());
        entity.setImageUrl(uploadUtils.uploadFileToCloudinary(request.getFile()));
        return productRepository.save(entity);
    }

    @Override
    public Product updateProduct(Integer id, ProductUpdateDto request) throws NotFoundException {
        // lấy thông tin cũ
        Product entity = productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product with " + id + " not found"));
        // chỉnh sửa thông tin nếu cần thiết
        entity.setName(request.getName());
        entity.setPrice(request.getPrice());
        entity.setSku(request.getSku());
        entity.setCategoryName(request.getCategoryName());
        if (request.getFile() != null && !request.getFile().isEmpty()) {
            entity.setImageUrl(uploadUtils.uploadFileToCloudinary(request.getFile()));
        }
        entity.setStatus(request.isStatus());
        return productRepository.save(entity);
    }

    @Override
    public void deleteProduct(Integer id) throws NotFoundException {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return;
        }
        throw new NotFoundException("Product with " + id + " not found");
    }
}
