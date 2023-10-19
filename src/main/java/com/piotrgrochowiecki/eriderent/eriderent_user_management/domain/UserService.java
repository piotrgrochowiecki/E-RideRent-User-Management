package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.exception.NotFoundRuntimeException;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.exception.UserAlreadyExistsRuntimeException;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.User;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.port.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerNewUser(@Nullable User user) {
        assert user != null;
        if (doesUserAlreadyExist(user.email())) {
            throw new UserAlreadyExistsRuntimeException(user.email());
        }
        userRepository.save(user);
        return user;
    }

    public User getById(@Nullable Long id) {
        assert id != null;
        if(userRepository.findById(id).isEmpty()) {
            throw new NotFoundRuntimeException(id.toString());
        }
        return userRepository.findById(id).get();
    }

    public User getByUuid(@Nullable String uuid) {
        assert uuid != null;
        if(userRepository.findByUuid(uuid).isEmpty()) {
            throw new NotFoundRuntimeException(uuid);
        }
        return userRepository.findByUuid(uuid).get();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    private boolean doesUserAlreadyExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }


}
