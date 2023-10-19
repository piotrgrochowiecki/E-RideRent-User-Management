package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.port;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.User;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(@Nullable String email);

    Optional<User> findById(@Nullable Long id);

    Optional<User> findByUuid(@Nullable String uuid);

    List<User> findAll();

    User save(User user);

}
