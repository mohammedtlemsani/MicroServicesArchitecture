package ma.enset.billingservice.feigns;

import jakarta.ws.rs.QueryParam;
import ma.enset.billingservice.entities.ProductItem;
import ma.enset.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORYSEVICE")
public interface ProductItemRestClient {
    @GetMapping(path = "/products/{id}")
    ProductItemRestClient findById(@PathVariable(name = "id") Long id);
    @GetMapping(path = "/products")
    PagedModel<Product> findAll(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size);

}
