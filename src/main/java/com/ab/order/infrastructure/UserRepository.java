package com.ab.order.infrastructure;

import com.ab.order.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {
    private HashMap<Long, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    public void saveToDb(User user) {
        users.put(user.getId(), user);
    }
}
