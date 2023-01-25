package org.test.service;

import org.test.model.User;

import java.util.List;


public interface UserService {
    
    void add(User user);
    
    List<User> getUserList();
    
    User getUserById(long id);
    
    void update(User user);
    
    void deleteUser(long id);
}
