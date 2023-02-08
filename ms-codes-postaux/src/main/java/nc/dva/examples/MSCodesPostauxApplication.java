package nc.dva.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MSCodesPostauxApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MSCodesPostauxApplication.class, args);
	}

}