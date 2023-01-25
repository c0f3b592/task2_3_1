package org.test.dao;

import org.test.model.User;
import java.util.List;

public interface UserDao {
   void add(User user);
   
   List<User> getUserList();
   
   User getUserById(long id);
   
   void update(User user);
   
   void delete(long id);
}
