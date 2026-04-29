package com.jacob.workout.session;

import java.time.LocalDateTime;

public class Session {

    private LocalDateTime started_at;
    private LocalDateTime ended_At;

    public Session() {
        this.started_at = LocalDateTime.now();
    }

    public void completeSession() {
        this.ended_At = LocalDateTime.now();
    }
}
