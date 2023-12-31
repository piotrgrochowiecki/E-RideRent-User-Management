package com.piotrgrochowiecki.eriderent.eriderent_user_management.data.DBadapter;

import com.piotrgrochowiecki.eriderent.eriderent_user_management.data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCRUDRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUuid(String uuid);

    List<UserEntity> findAll();

    boolean existsByEmail(String email);

}
