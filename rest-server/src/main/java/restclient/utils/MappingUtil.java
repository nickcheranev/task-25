package restclient.utils;

import restclient.dto.UserDto;
import org.springframework.stereotype.Component;
import restclient.jpa.domain.User;

@Component
public class MappingUtil {
    public UserDto toDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setName(user.getName())
                .setEmail(user.getEmail());
    }
}
