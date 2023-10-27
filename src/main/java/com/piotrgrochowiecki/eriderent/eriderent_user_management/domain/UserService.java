package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.exception.NotFoundRuntimeException;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.exception.UserAlreadyExistsRuntimeException;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.User;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User registerNewUser(User user) {
        if (userRepository.existsByEmail(user.email())) {
            throw new UserAlreadyExistsRuntimeException(user.email());
        }
        userRepository.save(user);
        return user;
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundRuntimeException(id.toString()));
    }

    public User getByUuid(String uuid) {
        return userRepository.findByUuid(uuid).orElseThrow(() -> new NotFoundRuntimeException(uuid));
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundRuntimeException(" "));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
