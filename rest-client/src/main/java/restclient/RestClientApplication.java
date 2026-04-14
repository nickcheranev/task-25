package restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import restclient.domain.User;
import restclient.services.UserRestClient;

@SpringBootApplication
@EnableCaching
@Slf4j
public class RestClientApplication implements CommandLineRunner {

	@Autowired
	private UserRestClient userRestClient;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) {
		var createdUser = userRestClient.create(new User().setName("user1").setEmail("user1@mail.ru"));
		log.info("{}", createdUser);

		log.info("Вызов клиента");
		var userById = userRestClient.getById(createdUser.getId());
		log.info("{}", userById);

		log.info("Вызов клиента - повтор. Отправки REST запроса быть не должно");
		userRestClient.getById(createdUser.getId());

		log.info("Вызов клиента");
		var allUsers = userRestClient.getAll();
		log.info("{}", allUsers);

		var updatedUser = userRestClient.update(createdUser.setName("name11").setEmail("email11@mail.ru"));
		log.info("{}", updatedUser);

		userRestClient.delete(createdUser.getId());
	}
}
