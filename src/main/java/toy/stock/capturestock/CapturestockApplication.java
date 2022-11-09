package toy.stock.capturestock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CapturestockApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapturestockApplication.class, args);
	}

}
