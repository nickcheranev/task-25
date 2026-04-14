package restserver.services;

import org.springframework.stereotype.Service;
import restserver.dto.UserDto;

import java.util.List;

/**
 * Сервис для работы с пользователями
 */
@Service
public interface UserService {
    /**
     * Получить всех пользователей
     *
     * @return список пользователей
     */
    List<UserDto> getAll();

    /**
     * Получить пользователя по идентификатору
     *
     * @param id идентификатор пользователя
     * @return пользователь
     */
    UserDto getById(Long id);

    /**
     * Добавить пользователя
     *
     * @param user данные пользователя
     * @return созданный пользователь
     */
    UserDto create(UserDto user);

    /**
     * Обновить данные автора
     *
     * @param id   идентификатор обновляемого пользователя
     * @param user данные пользователя
     * @return обновленный пользователь
     */
    UserDto update(Long id, UserDto user);

    /**
     * Удалить пользователя по идентификатору
     *
     * @param id идентификатор пользователя
     */
    void deleteById(Long id);
}
