package com.jacob.workout.session;

import java.util.ArrayList;
import java.util.List;

public class SessionLedger {
    private List<Session> sessions;

    public SessionLedger() {
        this.sessions = new ArrayList<>();
    }

    public void addSession(Session s) {
        this.sessions.add(s);
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
