package com.jacob.workout.user;

import com.jacob.workout.session.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserService {
    private Map<UUID, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public Session startUserSession(UUID id) {
        User u = getUserById(id);
        if (u.isInWorkout()) {
            throw new IllegalStateException("User already has session going");
        }
        u.toggleWorkout();
        Session s = new Session();
        u.getLedger().addSession(s);
        return s;
    }

    public Session endUserSession(UUID id) {
        User u = getUserById(id);
        if (!u.isInWorkout()) {
            throw new IllegalStateException("User isn't in a session currently");
        }
        u.toggleWorkout();
        Session s = u.getLedgerList().get(u.getLedgerSize() - 1);
        s.completeSession();
        return s;
    }

    public User removeUserById(UUID id) {
        return this.users.get(id);
    }

    public User addUser(User u) {
        this.users.put(u.getId(), u);
        return u;
    }

    public User getUserById(UUID id) {
        return this.users.get(id);
    }

    public Map<UUID, User> getUsers() {
        return this.users;
    }

    public void setUsers(Map<UUID, User> users) {
        this.users = users;
    }
}
