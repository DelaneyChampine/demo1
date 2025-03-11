package org.example.demo1;

import javafx.application.Platform;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class Timer {
    private LocalDateTime startTime = null;
    private boolean started = false;
    private Thread thread;
    private List<MyObserver> observers = new ArrayList<>();

    Timer() {
        startThread();
        start();
    }

    private void startThread() {
        thread = new Thread(() -> {
            while (true) {
                tick();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();

    }

    private void tick() {
        if (!started) return;
        notifyFolks();
    }

    private void notifyFolks() {
        for (MyObserver observer : observers) {
            observer.update(this);
        }
    }

    void addObserver(MyObserver observer) {
        observers.add(observer);
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
