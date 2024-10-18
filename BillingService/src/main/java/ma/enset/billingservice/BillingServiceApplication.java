package ma.enset.billingservice;

import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.entities.ProductItem;
import ma.enset.billingservice.feigns.CustomerRestClient;
import ma.enset.billingservice.feigns.ProductItemRestClient;
import ma.enset.billingservice.model.Customer;
import ma.enset.billingservice.model.Product;
import ma.enset.billingservice.repositories.BillRepository;
import ma.enset.billingservice.repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BillRepository billRepository, ItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient){
		return args -> {
			Customer customer = customerRestClient.findById(2L);
			billRepository.save(new Bill(1L,new Date(),null,customer.getId(),customer));
			PagedModel<Product> productItems = productItemRestClient.findAll(0,20);
			productItems.forEach(p->{
			ProductItem productItem = new ProductItem();
			productItem.setPrice(p.getPrice()*0.95);
			productItem.setQuantity(new Random().nextInt(100));
			productItem.setBill(billRepository.findById(1L).get());
			productItemRepository.save(productItem);
			});
			System.out.println("**********************************");
			System.out.println(billRepository.findById(1L).get());
			};
		};
	}
}
