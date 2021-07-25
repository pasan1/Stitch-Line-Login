package com.stitchline.api.service.impl;

import com.stitchline.api.exception.ValidateException;
import com.stitchline.api.model.User;
import com.stitchline.api.repo.UserRepo;
import com.stitchline.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final UserRepo repo;

    public UserServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public User addUser(User user) {
        Optional<User> op = repo.findByEmail(user.getEmail());
        if (op.isPresent()) {
            throw new ValidateException("User Already Exist");
        }

        if (!isUserNameAvailable(user)){
            throw new ValidateException("User Name Exist");
        }

        user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        User newUser = repo.insert(user);

        newUser.setPassword(new String(Base64.getDecoder().decode(newUser.getPassword())));
        return newUser;
    }

    @Override
    public boolean isUserNameAvailable(User user) {
        Optional<User> op = repo.findByUserName(user.getEmail());
        if (op.isPresent()) {
            return false;
        }
        return true;
    }

    @Override
    public User updateUser(User user) {
        User saveUser = repo.findByEmail(user.getEmail())
                .orElseThrow(() -> new ValidateException("Cannot find user by Email "+ user.getEmail()));

        saveUser.setName(user.getName());
        saveUser.setEmail(user.getEmail());
        saveUser.setMobile(user.getMobile());
        saveUser.setUserName(user.getUserName());
        saveUser.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        saveUser.setRole(user.getRole());
        saveUser.setData(user.getData());


        User newUser = repo.save(saveUser);
        newUser.setPassword(new String(Base64.getDecoder().decode(newUser.getPassword())));
        return newUser;
    }

    @Override
    public List<User> getAllUser() {
        List<User> all = repo.findAll();
        for (User u: all) {
            u.setPassword(new String(Base64.getDecoder().decode(u.getPassword())));
        }
        return all;
    }

    @Override
    public User searchUserByUserNameAndPassword(String userName, String password) {
        User newUser = repo.findByUserNameAndPassword(userName, Base64.getEncoder().encodeToString(password.getBytes()))
                .orElseThrow(() -> new ValidateException("Username and Password Incorrect"));

        newUser.setPassword(new String(Base64.getDecoder().decode(newUser.getPassword())));
        return newUser;
    }

    @Override
    public User searchUserByEmail(String email) {
        User newUser = repo.findByEmail(email)
                .orElseThrow(() -> new ValidateException("Email Incorrect"));
        newUser.setPassword(new String(Base64.getDecoder().decode(newUser.getPassword())));
        return newUser;
    }

    @Override
    public void deleteUser(String email) {
        Optional<User> user = repo.findByEmail(email);
        if (!user.isPresent()){
            throw new ValidateException("No User for Delete..!");
        }
        repo.delete(user.get());
    }
}
