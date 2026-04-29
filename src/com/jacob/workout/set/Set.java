package com.jacob.workout.set;

public class Set {
    private int reps;
    private double weight;
    private double RPE;

    public Set(int reps, double weight, double RPE) {
        setReps(reps);
        setWeight(weight);
        setRPE(RPE);
    }

    public double getRPE() {
        return this.RPE;
    }

    public void setRPE(double RPE) {
        if (RPE % .5 != 0) {
            throw new IllegalArgumentException("RPE must end in .5");
        } else if (RPE < 0) {
            throw new IllegalArgumentException("RPE must be greater than zero.");
        }
        this.RPE = RPE;
    }

    public int getReps() {
        return this.reps;
    }

    public void setReps(int reps) {
        if (reps < 0) {
            throw new IllegalArgumentException("Reps must be greater than zero.");
        }
        this.reps = reps;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }
        this.weight = weight;
    }
}
