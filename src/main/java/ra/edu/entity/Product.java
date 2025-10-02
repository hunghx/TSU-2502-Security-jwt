package ra.edu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sku;
    private String name;
    private String categoryName;
    private BigDecimal price;
    private String imageUrl;
    private boolean status;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        status = true;
        createdAt = LocalDateTime.now();
    }
}
