package com.jacob.workout;

import com.jacob.workout.exercise.Exercise;
import com.jacob.workout.session.Session;
import com.jacob.workout.set.Set;
import com.jacob.workout.user.User;
import com.jacob.workout.user.UserService;

public class Main {
    public static void main(String[] args) {
        UserService service = new UserService();

        User newUser = new User("Jacob", "Smith", 20, 214.0, 74);
        service.addUser(newUser);
        Session s = service.startUserSession(0);
        System.out.println("Session started!");
        Exercise e = new Exercise("Bench");
        s.addExercise(e);
        Set s1 = new Set(12, 135.0, 6.5);
        Set s2 = new Set(8, 205.0, 7.5);
        Set s3 = new Set(7, 225, 9.0);
        e.addSet(s1);
        e.addSet(s2);
        e.addSet(s3);
        s.completeSession();
    }
}
