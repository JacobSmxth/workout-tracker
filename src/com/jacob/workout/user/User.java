package com.jacob.workout.user;

import com.jacob.workout.session.SessionLedger;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private double weight;
    private int heightInch; // Keeping height in inches

    private SessionLedger ledger;

    // Statistic Variables
    private int totalWorkouts;
    private long totalVolume;

    private boolean inWorkout;

    public User(String first, String last, int age, double weight, int height) {
        this.firstName = first;
        this.lastName = last;
        setAge(age);
        setWeight(weight);
        setHeightInch(height);
        this.totalVolume = 0;
        this.totalWorkouts = 0;
        this.inWorkout = false;
        this.ledger = new SessionLedger();
    }

    public boolean isInWorkout() {
        return this.inWorkout;
    }

    public void toggleWorkout() {
        this.inWorkout = !this.inWorkout;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age can't be below or equal to zero.");
        } else if (age > 100) {
            throw new IllegalArgumentException(
                    "I don't see how anyone over 100 could still be working out. If this is true,"
                            + " contact the developer.");
        }
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight can't be below or equal to 0");
        }
        this.weight = weight;
    }

    public int getHeightInch() {
        return heightInch;
    }

    public void setHeightInch(int heightInch) {
        if (heightInch < 24) {
            throw new IllegalArgumentException("Height can't be below 2 feet (24 inches)");
        }
        this.heightInch = heightInch;
    }

    public int getTotalWorkouts() {
        return totalWorkouts;
    }

    public void setTotalWorkouts(int totalWorkouts) {
        if (totalWorkouts < 0) {
            throw new IllegalArgumentException("totalWorkouts can't be less than zero.");
        }
        this.totalWorkouts = totalWorkouts;
    }

    public long getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(long totalVolume) {
        if (totalVolume < 0) {
            throw new IllegalArgumentException("totalVolume can't be less than zero.");
        }
        this.totalVolume = totalVolume;
    }

    public SessionLedger getLedger() {
        return ledger;
    }

    public void setLedger(SessionLedger ledger) {
        this.ledger = ledger;
    }
}
