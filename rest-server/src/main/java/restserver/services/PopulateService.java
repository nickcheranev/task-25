package restserver.services;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restserver.jpa.domain.User;

/**
 * Сервис для начальной загрузки демонстрационных данных
 */
@Service
@RequiredArgsConstructor
public class PopulateService {
    private final EntityManager em;

    @Transactional
    public void populate() {
        em.persist(new User().setName("name").setEmail("email"));
    }
}