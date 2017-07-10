package com.emmiasilk.urealms.core.util;

/**
 * A tool for keeping track of the time between events.
 *
 * <p>Time is measured in nanoseconds.</p>
 */
public class StepTimer {
    /** The time of the latest tick as measures in nanoseconds. */
    private long lastTickTime;
    /** The length of the latest tick as measured in nanoseconds. */
    private long lastTickLength;

    /** The length of one second as measured in nanoseconds. */
    public static final int NANOS_IN_SECOND = 1_000_000_000;
    /** The length of one millisecond as measured in nanoseconds. */
    public static final int NANOS_IN_MILLISECOND = 1_000_000;

    /**
     * Creates a new {@code StepTimer}.
     *
     * <p>The last tick defaults to the time the ticker is created
     * and the length of the last tick defaults to 0 nanoseconds.</p>
     */
    public StepTimer() {
        set();
    }

    /**
     * @return The amount of time between the latest tick and the one before it, as measured
     * in nanoseconds.
     */
    public long getLastTickLength() {
        return lastTickLength;
    }

    /**
     * @return The system time in nanoseconds when the latest tick occurred.
     */
    public long getLastTickTime() {
        return lastTickTime;
    }

    /**
     * Updates the {@code lastTickTime} and {@code lastTickLength} based on the
     * current time and the time of the previous tick.
     *
     * <p>The {@code lastTickLength} is made to equal the difference between the time
     * of the previous tick and the the current time, as measures in nanoseconds
     * when this method is called.</p>
     *
     * <p>The {@code lastTickTime} is made to equal current time as measured in
     * nanoseconds when this method is called.</p>
     */
    public void tick() {
        long curTickTime = System.nanoTime();

        lastTickLength = curTickTime - lastTickTime;
        lastTickTime = curTickTime;
    }

    /**
     * Sets the {@code lastTickTime} to the current time in nanoseconds
     * and resets {@code lastTickLength} to 0.
     */
    public void set() {
        lastTickLength = 0;
        lastTickTime = System.nanoTime();
    }

}
