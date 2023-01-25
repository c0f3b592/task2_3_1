package org.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.test.model.User;
import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   
   @PersistenceContext
   private final EntityManager em;
   
   @Autowired
   public UserDaoImp(EntityManagerFactory emf) {
      this.em = emf.createEntityManager();
   }

   @Override
   public void add(User user) {
      em.persist(user);
   }
   
   @Override
   public List<User> getUserList() {
      TypedQuery<User> query = em.createQuery("select user from User user", User.class);
      return query.getResultList();
   }
   
   @Override
   public User getUserById(long id) {
      TypedQuery<User> query = em.createQuery("select user from User user where id=:id", User.class).setParameter("id", id);
      return query.getSingleResult();
   }
   
   @Override
   public void update(User user) {
      em.merge(user);
   }
   
   @Override
   public void delete(long id) {
      em.remove(getUserById(id));
   }
   
}
