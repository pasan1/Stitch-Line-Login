package com.stitchline.api.service;

import com.stitchline.api.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public boolean isUserNameAvailable(User user);

    public User updateUser(User user);

    public List<User> getAllUser();

    public User searchUserByUserNameAndPassword(String userName, String password);

    public User searchUserByEmail(String email);

    public void deleteUser(String email);
}
