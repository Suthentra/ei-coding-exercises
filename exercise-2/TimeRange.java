package com.ei.scheduler.core;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a range of time with validation and overlap checking.
 */
public final class TimeRange {
    private final LocalTime start;
    private final LocalTime end;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public TimeRange(String startTime, String endTime) {
        try {
            this.start = LocalTime.parse(startTime, FORMATTER);
            this.end = LocalTime.parse(endTime, FORMATTER);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Invalid time format. Use HH:mm");
        }
        if (this.end.isBefore(this.start) || this.end.equals(this.start)) {
            throw new IllegalArgumentException("End time must be after start time");
        }
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    /**
     * Checks if two TimeRanges overlap.
     */
    public boolean overlaps(TimeRange other) {
        return !this.end.isBefore(other.start) && !this.start.isAfter(other.end);
    }

    @Override
    public String toString() {
        return start.format(FORMATTER) + " - " + end.format(FORMATTER);
    }
}
