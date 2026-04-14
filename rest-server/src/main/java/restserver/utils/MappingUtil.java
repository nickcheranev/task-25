package restserver.utils;

import restserver.dto.UserDto;
import org.springframework.stereotype.Component;
import restserver.jpa.domain.User;

@Component
public class MappingUtil {
    public UserDto toDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail());
    }
}
