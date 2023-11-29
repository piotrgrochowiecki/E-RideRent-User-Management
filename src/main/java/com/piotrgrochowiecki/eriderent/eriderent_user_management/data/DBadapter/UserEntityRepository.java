package com.piotrgrochowiecki.eriderent.eriderent_user_management.data.DBadapter;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.data.password.PasswordUtils;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.data.entity.UserEntity;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.data.mapper.UserMapper;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.model.User;
import com.piotrgrochowiecki.eriderent.eriderent_user_management.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
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
    public Optional<User> findByEmail(String email) {
        return userCRUDRepository.findByEmail(email)
                .map(userMapper::mapToModel);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.mapToEntity(user);
        UUID uuid = UUID.randomUUID();
        userEntity.setUuid(uuid.toString());
        String hashedPassword = PasswordUtils.hashPassword(user.password());
        userEntity.setPassword(hashedPassword);
        UserEntity registeredUserEntity = userCRUDRepository.save(userEntity);
        return userMapper.mapToModel(registeredUserEntity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userCRUDRepository.findById(id)
                .map(userMapper::mapToModel);
    }

    @Override
    public Optional<User> findByUuid(String uuid) {
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

    @Override
    public boolean existsByEmail(String email) {
        return userCRUDRepository.existsByEmail(email);
    }

}
