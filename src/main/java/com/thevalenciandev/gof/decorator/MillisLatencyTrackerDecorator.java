package com.thevalenciandev.gof.decorator;

import com.thevalenciandev.gof.observer.v2.Observer;

import java.time.Duration;
import java.time.Instant;

public class MillisLatencyTrackerDecorator implements LatencyMeasurerDecorator {

    private final Observer delegate;

    private MillisLatencyTrackerDecorator(Observer delegate) {
        this.delegate = delegate;
    }

    public static MillisLatencyTrackerDecorator track(Observer delegate) {
        return new MillisLatencyTrackerDecorator(delegate);
    }

    @Override
    public void update() {
        Instant start = Instant.now();

        delegate.update();

        Instant end = Instant.now();
        System.out.println(delegate.getClass().getSimpleName() + " took " + Duration.between(start, end).toMillis() + " millis");
    }
}
