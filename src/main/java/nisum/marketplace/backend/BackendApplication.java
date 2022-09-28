package nisum.marketplace.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import nisum.marketplace.backend.service.CreditCardService;
import nisum.marketplace.backend.service.OrdersService;
import nisum.marketplace.backend.service.UserAddressService;

@SpringBootApplication(scanBasePackages = "nisum.*")
@EnableJpaRepositories(basePackages = "nisum.*")
@EntityScan(basePackages = "nisum.*")
public class BackendApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Autowired
	UserAddressService service;
	

	
	@Autowired
	OrdersService service2;
	

	@Override
	public void run(String... args) throws Exception {
		System.out.println(service2.getOrders());
		System.out.println('\n');
		System.out.println(service.getAddressById(5));

	}

}
