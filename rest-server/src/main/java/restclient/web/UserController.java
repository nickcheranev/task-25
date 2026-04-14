package restclient.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restclient.dto.UserDto;
import restclient.services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	/**
	 * Получить список всех пользователей
	 */
	@GetMapping
	public List<UserDto> allUsers() {
		return userService.getAll();
	}

	/**
	 * Получить список всех пользователей
	 */
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable("id") Long id) {
		return userService.getById(id);
	}

	/**
	 * Добавить пользователя в хранилище
	 *
	 * @param user Добавляемый пользователь
	 */
	@PostMapping
	public UserDto createUser(@RequestBody UserDto user) {
		return userService.create(user);
	}

	/**
	 * Изменить имеющегося пользователя в хранилище
	 *
	 * @param user Обновляемый пользователь
	 */
	@PutMapping("/{id}")
	public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto user) {
		return userService.update(id, user);
	}

	/**
	 * Удалить пользователя из хранилища по id
	 *
	 * @param id идентификатор удаляемого пользователя
	 */
	@DeleteMapping("/{id}")
	public void deleteAuthorById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}

}
