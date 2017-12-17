package hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
@SpringBootApplication
public class ApplicationRunTest {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ApplicationRunTest.class);
		Environment ment = app.run(args).getEnvironment();
		
	}
}
