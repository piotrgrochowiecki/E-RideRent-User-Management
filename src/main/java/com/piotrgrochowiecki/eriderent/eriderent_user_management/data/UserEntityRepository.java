package com.piotrgrochowiecki.eriderent.eriderent_user_management.data;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.User;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class UserEntityRepository implements UserRepository {

    private final UserCRUDRepository userCRUDRepository;
    private final UserMapper userMapper;

    @Override
    public Optional<User> findByEmail(@Nullable String email) {
        return userCRUDRepository.findByEmail(email)
                .map(userMapper::mapToModel);
    }

    @Override
    public User save(@Nullable User user) {
        assert user != null;
        UserEntity userEntity = userMapper.mapToEntity(user);
        UUID uuid = UUID.randomUUID();
        userEntity.setUuid(uuid.toString());
        UserEntity registeredUserEntity = userCRUDRepository.save(userEntity);
        return userMapper.mapToModel(registeredUserEntity);
    }

    @Override
    public Optional<User> findById(@Nullable Long id) {
        assert id != null;
        return userCRUDRepository.findById(id)
                .map(userMapper::mapToModel);
    }

    @Override
    public Optional<User> findByUuid(@Nullable String uuid) {
        assert uuid != null;
        return userCRUDRepository.findByUuid(uuid)
                .map(userMapper::mapToModel);
    }

    @Override
    public List<User> findAll() {
        return userCRUDRepository.findAll()
                .stream()
                .map(userMapper::mapToModel)
                .collect(Collectors.toList());
    }

}
