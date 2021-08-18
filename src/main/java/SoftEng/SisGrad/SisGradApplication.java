package SoftEng.SisGrad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"Models","Controllers","Models.Repositories"})
@EnableJpaRepositories("Models")
@EntityScan({"Models"})
@EnableAutoConfiguration

public class SisGradApplication {
	public static void main(String[] args) {
		SpringApplication.run(SisGradApplication.class, args);
	}

}