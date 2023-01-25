package org.test.service;

import org.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.model.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    
    private final UserDao userDao;
    
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return userDao.getUserList();
    }
    
    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
    
    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }
    
    @Override
    @Transactional
    public void deleteUser(long id) {
        userDao.delete(id);
    }
}
