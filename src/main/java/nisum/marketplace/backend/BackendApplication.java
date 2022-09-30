package nisum.marketplace.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nisum.marketplace.backend.service.CreditCardService;
import nisum.marketplace.backend.service.OrderItemsService;
import nisum.marketplace.backend.service.OrdersService;
import nisum.marketplace.backend.service.ProductsService;

@SpringBootApplication(scanBasePackages = "nisum.*")
@EnableJpaRepositories(basePackages = "nisum.*")
@EntityScan(basePackages = "nisum.*")
public class BackendApplication implements CommandLineRunner{


	public static void main(String[] args)  {
		SpringApplication.run(BackendApplication.class, args);
	}

	
	@Autowired
	OrderItemsService service;
    
    @Override
    public void run(String... args) throws Exception{
        System.out.println(service.getOrderItemsUser(4));
    }
	

	@Bean 	
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
}

