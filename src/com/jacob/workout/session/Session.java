package com.jacob.workout.session;

import com.jacob.workout.exercise.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Session {

    private List<Exercise> exercises;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private long DurationInSeconds;

    public Session() {
        this.exercises = new ArrayList<>();
        this.startedAt = LocalDateTime.now();
        this.DurationInSeconds = 0;
        this.endedAt = null;
    }

    private static long calculateDuration(LocalDateTime s, LocalDateTime e) {
        Duration duration = Duration.between(s, e);
        return duration.toSeconds();
    }

    public long getCurrentDuration() {
        return calculateDuration(this.startedAt, LocalDateTime.now());
    }

    public void completeSession() {
        this.endedAt = LocalDateTime.now();
        setDurationInSeconds(calculateDuration(this.startedAt, this.endedAt));
    }

    public void addExercise(Exercise e) {
        this.exercises.add(e);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public int getNumberOfExercises() {
        return this.exercises.size();
    }

    public void setExercises(List<Exercise> exercises) {
        for (Exercise e : exercises) {
            addExercise(e);
        }
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public long getDurationInSeconds() {
        return DurationInSeconds;
    }

    public void setDurationInSeconds(long durationInSeconds) {
        if (DurationInSeconds < 0) {
            throw new IllegalArgumentException("Duration can't be below zero.");
        }
        this.DurationInSeconds = durationInSeconds;
    }
}
