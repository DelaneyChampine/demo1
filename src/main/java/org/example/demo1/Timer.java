package org.example.demo1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class Timer {
    private LocalDateTime startTime = null;
    private boolean started = false;

    Timer() {
        start();
    }

    void start() {
        startTime = LocalDateTime.now();
        started = true;
    }

    long getTime() {
        LocalDateTime now = LocalDateTime.now();
        return startTime.until(now, ChronoUnit.SECONDS);
    }
}
