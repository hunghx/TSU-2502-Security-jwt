package ra.edu.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
@Setter
@Getter
public class ProductUpdateDto {
    private String sku;
    private String name;
    private String categoryName;
    private BigDecimal price;
    private MultipartFile file;
    private boolean status;
}
