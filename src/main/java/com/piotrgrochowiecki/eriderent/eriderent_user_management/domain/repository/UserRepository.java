package com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.repository;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    Optional<User> findByUuid(String uuid);

    List<User> findAll();

    User save(User user);

    boolean existsByEmail(String email);

}
