package com.xh.vdcluster.repository.mapper;

import com.xh.vdcluster.repository.model.User;

/**
 * Created by macbookpro on 17/7/23.
 */
public interface UserMapper {
    User getUserById(int id);

    User getUserByUserId(String userId);

    User getUserByUsername(String username);

    void insertUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    void updateUserToken(String userId, String token);

    String getTokenByUserId(String userId);

    Integer getGrainByUserId(String userId);
}
