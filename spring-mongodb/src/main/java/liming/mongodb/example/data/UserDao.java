/**
 * Copyright (c) 2012 Sohu. All Rights Reserved
 */
package liming.mongodb.example.data;

import java.util.List;

import liming.mongodb.example.data.model.UserEntity;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao {

    public abstract void _test();

    public abstract void createCollection();

    public abstract List<UserEntity> findList(int skip, int limit);

    public abstract List<UserEntity> findListByAge(int age);

    public abstract UserEntity findOne(String id);

    public abstract UserEntity findOneByUsername(String username);

    public abstract void insert(UserEntity entity);

    public abstract void update(UserEntity entity);

}