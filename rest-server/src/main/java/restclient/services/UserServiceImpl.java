package restclient.services;

import lombok.RequiredArgsConstructor;
import restclient.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restclient.exception.NotFoundException;
import restclient.jpa.UserRepository;
import restclient.jpa.domain.User;
import restclient.utils.MappingUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MappingUtil mapper;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getById(Long id) {
        var foundUser = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Не найден пользователь с идентификатором " + id));
        return mapper.toDto(foundUser);
    }

    @Override
    @Transactional
    public UserDto create(UserDto user) {
        var userEntity = new User().setName(user.getName()).setEmail(user.getEmail());
        return mapper.toDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDto update(Long id, UserDto user) {
        var foundUser = userRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Не найден пользователь с идентификатором " + id));
        foundUser.setName(user.getName());
        foundUser.setEmail(user.getEmail());
        return mapper.toDto(userRepository.save(foundUser));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
