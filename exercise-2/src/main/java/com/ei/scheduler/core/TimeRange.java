package com.ei.scheduler.core;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeRange {
    private final LocalTime start;
    private final LocalTime end;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public TimeRange(String start, String end) {
        this.start = LocalTime.parse(start, FORMATTER);
        this.end = LocalTime.parse(end, FORMATTER);
        if (this.end.isBefore(this.start)) {
            throw new IllegalArgumentException("End time must be after start time");
        }
    }

    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }

    public boolean overlaps(TimeRange other) {
        return !(end.isBefore(other.start) || start.isAfter(other.end));
    }

    @Override
    public String toString() {
        return start.format(FORMATTER) + " - " + end.format(FORMATTER);
    }
}
