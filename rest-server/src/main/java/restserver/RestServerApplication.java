package restserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import restserver.services.PopulateService;

@SpringBootApplication
public class RestServerApplication {
	public static void main(String[] args) {
		var context = SpringApplication.run(RestServerApplication.class, args);
		context.getBean(PopulateService.class).populate();
	}
}
