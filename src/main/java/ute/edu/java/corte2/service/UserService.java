package ute.edu.java.corte2.service;

import java.util.List;

import ute.edu.java.corte2.model.User;

public interface UserService {
    
    List<User> findAll();

    User createUser(User user);

    User searchUserById(int id);

    void deleteUser(int id);

}
