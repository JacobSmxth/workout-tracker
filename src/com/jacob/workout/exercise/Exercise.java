package com.jacob.workout.exercise;

import com.jacob.workout.set.*;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private String name;

    private double totalVolume;
    private double avgRPE;
    private int totalReps;

    private List<Set> sets;

    public Exercise(String name) {
        this.name = name;
        sets = new ArrayList<>();
        this.totalVolume = 0;
        this.totalReps = 0;
        this.avgRPE = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName() {
        this.name = name;
    }

    public void addSet(Set newSet) {
        int currentLen = this.sets.size(); // Just so I can call once and keep local
        this.avgRPE *= currentLen; // To get total RPE
        this.avgRPE += newSet.getRPE(); // Add new RPE value
        this.avgRPE /= currentLen + 1; // Get new average
        this.sets.add(newSet);
        this.totalVolume += newSet.getWeight();
        this.totalReps += newSet.getReps();
    }

    public void setSets(List<Set> sets) {
        for (Set set : sets) {
            addSet(set);
        }
    }

    public List<Set> getSets() {
        return this.sets;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public double getAvgRPE() {
        return avgRPE;
    }

    public void setAvgRPE(double avgRPE) {
        this.avgRPE = avgRPE;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }
}
