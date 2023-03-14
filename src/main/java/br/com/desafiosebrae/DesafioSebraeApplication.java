package br.com.desafiosebrae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioSebraeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSebraeApplication.class, args);
	}

}
