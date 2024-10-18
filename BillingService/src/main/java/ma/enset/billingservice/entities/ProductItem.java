package ma.enset.billingservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import ma.enset.billingservice.model.Product;

@Entity
@Data
public class ProductItem {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private double quantity;
    private Long productId;
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;
}
