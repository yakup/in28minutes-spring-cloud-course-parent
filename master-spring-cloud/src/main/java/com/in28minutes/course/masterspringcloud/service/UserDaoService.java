package com.in28minutes.course.masterspringcloud.service;

import com.in28minutes.course.masterspringcloud.controller.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    {
        users.add(new User(1, "Adam", new Date(), null));
        users.add(new User(2, "Eve", new Date(), null));
        users.add(new User(3, "Jack", new Date(), null));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(id)) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }
}
