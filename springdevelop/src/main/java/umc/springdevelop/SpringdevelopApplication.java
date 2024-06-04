package umc.springdevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringdevelopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdevelopApplication.class, args);
	}

}
