package ma.enset.billingservice.feigns;

import jakarta.ws.rs.Path;
import ma.enset.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMERSERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/customers/{id}")
    public Customer findById(@PathVariable(name="id") Long id);
}
