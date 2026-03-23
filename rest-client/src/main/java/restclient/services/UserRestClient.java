
package restclient.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import restclient.domain.User;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRestClient {
    private static final String URL = "http://localhost:8080/";
    private static final String MSG = "Отправка REST запроса";
    private final RestOperations restOperations;

    @Cacheable("users")
    public List<User> getAll() {
        log.info(MSG);
        var response = restOperations.exchange(URL + "users", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {});
        return response.getBody();
    }

    public User create(User user) {
        var createdUser = restOperations.postForObject(URL + "users", user, User.class);
        log.info("{}", createdUser);
        return createdUser;
    }

    @Cacheable("users")
    public User getById(Long id) {
        log.info(MSG);
        return restOperations.getForObject(URL + "users/{id}", User.class, id);
    }

    @CacheEvict(value = "users", allEntries = true, key = "#user.id")
    public User update(User user) {
        restOperations.put(URL + "users/{id}", user, user.getId());
        log.info("{}", user);
        return user;
    }

    @CacheEvict(value = "users", allEntries = true)
    public void delete(Long id) {
        restOperations.delete(URL + "users/{id}", id);
    }
}
