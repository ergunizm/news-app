package com.ergun.news.business.abstracts;

import com.ergun.news.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(int id);

}
