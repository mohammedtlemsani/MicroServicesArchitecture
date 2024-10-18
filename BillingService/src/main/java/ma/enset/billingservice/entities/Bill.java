package ma.enset.billingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ma.enset.billingservice.model.Customer;

import java.util.Collection;
import java.util.Date;

@Entity
@AllArgsConstructor@NoArgsConstructor@ToString
public class Bill {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private Date billingDate;
   @OneToMany(mappedBy = "bill",fetch = FetchType.EAGER)
   private Collection<ProductItem> productItems;
   private Long customerId;
   @Transient
   private Customer customer;
}
