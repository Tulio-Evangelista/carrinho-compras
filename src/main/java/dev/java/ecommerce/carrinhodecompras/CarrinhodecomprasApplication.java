package dev.java.ecommerce.carrinhodecompras;

import dev.java.ecommerce.carrinhodecompras.request.PagamentoRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableCaching
@EnableFeignClients
@SpringBootApplication
public class CarrinhodecomprasApplication {


	public static void main(String[] args) {
		SpringApplication.run(CarrinhodecomprasApplication.class, args);
	}




}
