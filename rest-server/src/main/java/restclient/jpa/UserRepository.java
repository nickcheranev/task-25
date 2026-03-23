package restclient.jpa;

import org.springframework.data.repository.ListCrudRepository;
import restclient.jpa.domain.User;

/**
 * JPA репозиторий пользователей
 */
public interface UserRepository extends ListCrudRepository<User, Long> {
}
