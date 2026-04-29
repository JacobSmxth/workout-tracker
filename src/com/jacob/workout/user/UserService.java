package com.jacob.workout.user;

import com.jacob.workout.session.Session;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public Session startUserSession(int id) {
        User u = getUserById(id);
        if (u.isInWorkout()) {
            throw new IllegalStateException("User already has session going");
        }
        u.toggleWorkout();
        Session s = new Session();
        u.getLedger().addSession(s);
        return s;
    }

    public User removeUserById(int id) {
        return this.users.remove(id);
    }

    public User addUser(User u) {
        this.users.add(u);
        return u;
    }

    public User getUserById(int id) {
        return this.users.get(id);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
