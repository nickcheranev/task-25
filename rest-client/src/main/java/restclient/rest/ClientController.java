package restclient.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restclient.domain.User;
import restclient.services.UserRestClient;

/**
 * REST контроллер для демонстрации запросов от клиента серверу
 */
@RestController
@RequestMapping("/client")
@Slf4j
@RequiredArgsConstructor
public class ClientController {
    private final UserRestClient userRestClient;

    /**
     * Сценарий для демонстрации обмена данными с сервером по REST
     *
     * @return OK
     */
    @GetMapping("test")
    public ResponseEntity<String> test() {
        // создание пользователя
        var createdUser = userRestClient.create(new User().setName("user1").setEmail("user1@mail.ru"));
        log.info("{}", createdUser);

        // получение пользователя по id
        log.info("Вызов клиента");
        var userById = userRestClient.getById(createdUser.getId());
        log.info("{}", userById);

        // повторное получение пользователя по id, результат будет получен из кеша
        log.info("Вызов клиента - повтор. Отправки REST запроса быть не должно");
        userRestClient.getById(createdUser.getId());

        // получение всех пользователей
        log.info("Вызов клиента");
        var allUsers = userRestClient.getAll();
        log.info("{}", allUsers);

        // обновление пользователя
        var updatedUser = userRestClient.update(createdUser.setName("name11").setEmail("email11@mail.ru"));
        log.info("{}", updatedUser);

        // удаление пользователя
        userRestClient.delete(createdUser.getId());
        return ResponseEntity.ok("OK");
    }
}
