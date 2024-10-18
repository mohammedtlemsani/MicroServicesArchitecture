package ma.enset.customerservice;

import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"oussama","oussama@gmail.com"));
			customerRepository.save(new Customer(null,"yassine","yassine@gmail.com"));
			customerRepository.save(new Customer(null,"mohamed","mohammed@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
