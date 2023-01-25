package org.test.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.test.model.User;
import org.test.service.UserService;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Util {
    
    private final UserService service;
    
    @Autowired
    public Util(UserService service) {
        this.service = service;
    }
    
    @PostConstruct
    @Transactional
    public void fillTable() {
        service.addUser(new User("имя1", "фамилия1", (byte) 42, "почта1"));
        service.addUser(new User("имя2", "фамилия2", (byte) 42, "почта2"));
        service.addUser(new User("имя3", "фамилия3", (byte) 42, "почта3"));
        service.addUser(new User("имя4", "фамилия4", (byte) 42, "почта4"));
        service.addUser(new User("имя5", "фамилия5", (byte) 42, "почта5"));
    }
    
    @PreDestroy
    @Transactional
    public void cleanTable() {
        service.cleanUser();
    }
    
}
