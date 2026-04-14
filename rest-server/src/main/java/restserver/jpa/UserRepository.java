package restserver.jpa;

import org.springframework.data.repository.ListCrudRepository;
import restserver.jpa.domain.User;

/**
 * JPA репозиторий пользователей
 */
public interface UserRepository extends ListCrudRepository<User, Long> {
}
