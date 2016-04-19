package com.onk.group3;

import com.github.javafaker.Faker;
import com.onk.group3.models.Customer;
import com.onk.group3.repositories.Customer1Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnkCustomerServiceApplication {

	private final Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(OnkCustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDb(Customer1Repository repository){
		return (args) -> {
			repository.deleteAll();
			//Insert some Customers
				repository.save(new Customer("Hans Hansen", "Hansvej 1", "hans@hansmail.com"));
				repository.save(new Customer("Jørgen Clausen", "Jørgenvej 55", "jørgen@jørgenmail.com"));
				repository.save(new Customer("Svend Lokumsen", "Svendvej 21", "svend@svendmail.com"));
		};
	}
}
